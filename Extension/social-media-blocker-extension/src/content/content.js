// Content script for Social Media Blocker
// Handles social media detection, time entry, and full-screen blocking

let isBlocked = false;
let timeLimit = 0;
let timeSpent = 0;
let isTimerActive = false;
let timerInterval = null;
let blockOverlay = null;

// List of popular social media domains
const socialMediaDomains = [
    'facebook.com', 'fb.com', 'instagram.com', 'twitter.com', 'x.com',
    'tiktok.com', 'youtube.com', 'linkedin.com', 'reddit.com', 'snapchat.com',
    'pinterest.com', 'tumblr.com', 'whatsapp.com', 'telegram.org', 'discord.com',
    'twitch.tv', 'vimeo.com', 'dailymotion.com', 'vine.co', 'periscope.tv'
];

// Check if current site is social media
function isSocialMediaSite() {
    const currentDomain = window.location.hostname.toLowerCase().replace(/^www\./, '');
    return socialMediaDomains.some(domain => 
        currentDomain.includes(domain) || domain.includes(currentDomain)
    );
}

// Show time entry popup when social media is detected
function showTimeEntryPopup() {
    const popup = document.createElement('div');
    popup.id = 'social-media-time-entry';
    popup.style.cssText = `
        position: fixed;
        top: 0;
        left: 0;
        width: 100vw;
        height: 100vh;
        background: rgba(0, 0, 0, 0.95);
        z-index: 999999999;
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        backdrop-filter: blur(10px);
    `;

    popup.innerHTML = `
        <div style="
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            padding: 40px;
            border-radius: 20px;
            text-align: center;
            max-width: 500px;
            width: 90%;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            color: white;
        ">
            <div style="font-size: 48px; margin-bottom: 20px;">⏰</div>
            <h2 style="margin: 0 0 20px 0; font-size: 28px; font-weight: 600;">
                Social Media Time Limit
            </h2>
            <p style="margin: 0 0 30px 0; font-size: 16px; opacity: 0.9; line-height: 1.5;">
                How long would you like to spend on <strong>${window.location.hostname}</strong> today?
            </p>
            
            <div style="margin-bottom: 30px;">
                <input type="number" id="time-input" min="1" max="180" value="30" 
                    style="
                        width: 100px;
                        padding: 15px;
                        font-size: 24px;
                        text-align: center;
                        border: none;
                        border-radius: 10px;
                        margin-right: 10px;
                        font-weight: bold;
                        color: #333;
                    "
                />
                <span style="font-size: 18px; font-weight: 500;">minutes</span>
            </div>

            <div style="display: flex; gap: 15px; justify-content: center;">
                <button id="set-time-btn" style="
                    background: white;
                    color: #667eea;
                    border: none;
                    padding: 15px 30px;
                    border-radius: 10px;
                    font-size: 16px;
                    font-weight: 600;
                    cursor: pointer;
                    transition: all 0.3s ease;
                ">
                    ✓ Set Time Limit
                </button>
                <button id="leave-site-btn" style="
                    background: transparent;
                    color: white;
                    border: 2px solid white;
                    padding: 15px 30px;
                    border-radius: 10px;
                    font-size: 16px;
                    font-weight: 600;
                    cursor: pointer;
                    transition: all 0.3s ease;
                ">
                    🚪 Leave Site
                </button>
            </div>

            <div style="margin-top: 20px; font-size: 12px; opacity: 0.7;">
                This will help you maintain healthy social media habits
            </div>
        </div>
    `;

    document.body.appendChild(popup);

    // Add event listeners
    const timeInput = popup.querySelector('#time-input');
    const setTimeBtn = popup.querySelector('#set-time-btn');
    const leaveSiteBtn = popup.querySelector('#leave-site-btn');

    // Focus on input
    timeInput.focus();

    // Handle enter key
    timeInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            setTimeLimit();
        }
    });

    setTimeBtn.addEventListener('click', setTimeLimit);
    leaveSiteBtn.addEventListener('click', () => {
        window.location.href = 'about:blank';
    });

    function setTimeLimit() {
        const minutes = parseInt(timeInput.value);
        if (minutes && minutes > 0 && minutes <= 180) {
            timeLimit = minutes * 60; // Convert to seconds
            timeSpent = 0;
            
            // Save to storage
            chrome.storage.local.set({
                [`${window.location.hostname}_timeLimit`]: timeLimit,
                [`${window.location.hostname}_timeSpent`]: 0,
                [`${window.location.hostname}_startTime`]: Date.now()
            });

            popup.remove();
            startTimer();
        } else {
            timeInput.style.border = '2px solid #ff4757';
            setTimeout(() => {
                timeInput.style.border = 'none';
            }, 2000);
        }
    }
}

// Start the background timer
function startTimer() {
    isTimerActive = true;
    
    timerInterval = setInterval(() => {
        if (document.visibilityState === 'visible') {
            timeSpent++;
            
            // Update storage every 10 seconds
            if (timeSpent % 10 === 0) {
                chrome.storage.local.set({
                    [`${window.location.hostname}_timeSpent`]: timeSpent
                });
            }

            // Check if time limit reached
            if (timeSpent >= timeLimit) {
                showFullScreenBlock();
            }
        }
    }, 1000);
}

// Show full-screen blocking overlay
function showFullScreenBlock() {
    clearInterval(timerInterval);
    isBlocked = true;

    // Hide all website content
    document.body.style.display = 'none';
    document.documentElement.style.overflow = 'hidden';

    blockOverlay = document.createElement('div');
    blockOverlay.id = 'social-media-block-overlay';
    blockOverlay.style.cssText = `
        position: fixed;
        top: 0;
        left: 0;
        width: 100vw;
        height: 100vh;
        background: linear-gradient(135deg, #ff6b6b 0%, #ee5a52 100%);
        z-index: 999999999;
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        color: white;
        user-select: none;
        pointer-events: all;
    `;

    const minutes = Math.floor(timeLimit / 60);
    
    blockOverlay.innerHTML = `
        <div style="text-align: center; max-width: 600px; padding: 40px;">
            <div style="font-size: 120px; margin-bottom: 30px; animation: pulse 2s infinite;">⏰</div>
            
            <h1 style="font-size: 42px; margin: 0 0 20px 0; font-weight: 700;">
                Time's Up!
            </h1>
            
            <p style="font-size: 24px; margin: 0 0 30px 0; opacity: 0.9; line-height: 1.4;">
                You've spent <strong>${minutes} minutes</strong> on social media.
            </p>
            
            <div style="
                background: rgba(255,255,255,0.2);
                padding: 30px;
                border-radius: 15px;
                margin: 30px 0;
                backdrop-filter: blur(10px);
            ">
                <h3 style="margin: 0 0 15px 0; font-size: 20px;">
                    🌟 Great job managing your time!
                </h3>
                <p style="margin: 0; font-size: 16px; opacity: 0.9;">
                    Consider doing something productive:<br>
                    📚 Read a book • 🏃‍♂️ Exercise • 🎨 Be creative • 💼 Work on goals
                </p>
            </div>

            <div style="display: flex; gap: 20px; justify-content: center; flex-wrap: wrap;">
                <button id="extend-time-btn" style="
                    background: rgba(255,255,255,0.2);
                    color: white;
                    border: 2px solid white;
                    padding: 15px 30px;
                    border-radius: 10px;
                    font-size: 16px;
                    font-weight: 600;
                    cursor: pointer;
                    transition: all 0.3s ease;
                    backdrop-filter: blur(10px);
                ">
                    ⏱️ +10 More Minutes
                </button>
                
                <button id="finish-session-btn" style="
                    background: white;
                    color: #ff6b6b;
                    border: none;
                    padding: 15px 30px;
                    border-radius: 10px;
                    font-size: 16px;
                    font-weight: 600;
                    cursor: pointer;
                    transition: all 0.3s ease;
                ">
                    ✨ Finish Session
                </button>
            </div>

            <div style="margin-top: 30px; font-size: 14px; opacity: 0.7;">
                This extension helps you maintain healthy digital habits
            </div>
        </div>
    `;

    document.documentElement.appendChild(blockOverlay);

    // Add event listeners
    const extendBtn = blockOverlay.querySelector('#extend-time-btn');
    const finishBtn = blockOverlay.querySelector('#finish-session-btn');

    extendBtn.addEventListener('click', () => {
        timeLimit += 600; // Add 10 minutes
        chrome.storage.local.set({
            [`${window.location.hostname}_timeLimit`]: timeLimit
        });
        removeBlockOverlay();
        startTimer();
    });

    finishBtn.addEventListener('click', () => {
        window.location.href = 'about:blank';
    });

    // Add pulsing animation
    const style = document.createElement('style');
    style.textContent = `
        @keyframes pulse {
            0% { transform: scale(1); }
            50% { transform: scale(1.1); }
            100% { transform: scale(1); }
        }
    `;
    document.head.appendChild(style);

    // Disable all interactions with the page
    disablePageInteractions();
}

// Remove block overlay and restore page
function removeBlockOverlay() {
    if (blockOverlay) {
        blockOverlay.remove();
        blockOverlay = null;
    }
    document.body.style.display = '';
    document.documentElement.style.overflow = '';
    isBlocked = false;
    enablePageInteractions();
}

// Disable all page interactions
function disablePageInteractions() {
    // Prevent scrolling
    document.addEventListener('wheel', preventDefault, { passive: false });
    document.addEventListener('touchmove', preventDefault, { passive: false });
    document.addEventListener('keydown', preventNavigation);
    
    // Disable context menu
    document.addEventListener('contextmenu', preventDefault);
    
    // Disable selection
    document.body.style.userSelect = 'none';
}

// Enable page interactions
function enablePageInteractions() {
    document.removeEventListener('wheel', preventDefault);
    document.removeEventListener('touchmove', preventDefault);
    document.removeEventListener('keydown', preventNavigation);
    document.removeEventListener('contextmenu', preventDefault);
    document.body.style.userSelect = '';
}

function preventDefault(e) {
    e.preventDefault();
}

function preventNavigation(e) {
    // Prevent F5, Ctrl+R, Ctrl+F5, etc.
    if (e.key === 'F5' || (e.ctrlKey && (e.key === 'r' || e.key === 'R'))) {
        e.preventDefault();
    }
}

// Check existing time data on load
function checkExistingSession() {
    const hostname = window.location.hostname;
    
    chrome.storage.local.get([
        `${hostname}_timeLimit`,
        `${hostname}_timeSpent`,
        `${hostname}_startTime`
    ], (result) => {
        const existingLimit = result[`${hostname}_timeLimit`];
        const existingSpent = result[`${hostname}_timeSpent`] || 0;
        const startTime = result[`${hostname}_startTime`];
        
        // Check if session is from today
        const isToday = startTime && (Date.now() - startTime) < 24 * 60 * 60 * 1000;
        
        if (existingLimit && isToday) {
            timeLimit = existingLimit;
            timeSpent = existingSpent;
            
            if (timeSpent >= timeLimit) {
                showFullScreenBlock();
            } else {
                startTimer();
            }
        } else {
            // New session or expired - clear old data and show popup
            chrome.storage.local.remove([
                `${hostname}_timeLimit`,
                `${hostname}_timeSpent`,
                `${hostname}_startTime`
            ]);
            showTimeEntryPopup();
        }
    });
}

// Initialize when page loads
if (isSocialMediaSite()) {
    // Wait for page to be fully loaded
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', checkExistingSession);
    } else {
        checkExistingSession();
    }
}

// Handle visibility changes
document.addEventListener('visibilitychange', () => {
    if (isBlocked) {
        // Ensure block overlay stays visible
        if (!document.getElementById('social-media-block-overlay')) {
            showFullScreenBlock();
        }
    }
});

console.log('Social Media Blocker initialized for:', window.location.hostname);