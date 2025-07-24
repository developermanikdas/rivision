// Background script for Social Media Blocker
// Simplified version for Chrome Store - handles cleanup and data management

// Clean up old storage data daily
chrome.runtime.onStartup.addListener(() => {
    cleanupOldData();
});

chrome.runtime.onInstalled.addListener(() => {
    cleanupOldData();
    console.log('Social Media Blocker extension installed/updated');
});

// Clean up storage data older than 24 hours
function cleanupOldData() {
    chrome.storage.local.get(null, (data) => {
        const now = Date.now();
        const keysToRemove = [];
        
        for (const key in data) {
            if (key.endsWith('_startTime')) {
                const startTime = data[key];
                // Remove data older than 24 hours
                if (now - startTime > 24 * 60 * 60 * 1000) {
                    const hostname = key.replace('_startTime', '');
                    keysToRemove.push(
                        key,
                        `${hostname}_timeLimit`,
                        `${hostname}_timeSpent`
                    );
                }
            }
        }
        
        if (keysToRemove.length > 0) {
            chrome.storage.local.remove(keysToRemove, () => {
                console.log('Cleaned up old session data for:', keysToRemove.length / 3, 'sites');
            });
        }
    });
}

// Handle messages from content scripts (for future features)
chrome.runtime.onMessage.addListener((request, sender, sendResponse) => {
    if (request.action === 'logUsage') {
        // Log usage statistics (for future analytics)
        console.log('Usage logged:', request.data);
        sendResponse({ status: 'logged' });
    } else if (request.action === 'getStats') {
        // Get usage statistics (for future dashboard)
        chrome.storage.local.get(null, (data) => {
            sendResponse({ stats: data });
        });
        return true;
    }
});

// Set up daily cleanup alarm
chrome.alarms.onAlarm.addListener((alarm) => {
    if (alarm.name === 'dailyCleanup') {
        cleanupOldData();
    }
});

// Create daily cleanup alarm
chrome.alarms.create('dailyCleanup', {
    delayInMinutes: 1440, // 24 hours
    periodInMinutes: 1440 // Repeat every 24 hours
});

console.log('Social Media Blocker background script initialized');