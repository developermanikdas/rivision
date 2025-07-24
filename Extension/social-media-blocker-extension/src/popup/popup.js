document.addEventListener('DOMContentLoaded', function() {
    const clearAllBtn = document.getElementById('clear-all-btn');
    const activeSessionsDiv = document.getElementById('active-sessions');

    // Load and display active sessions
    loadActiveSessions();

    // Set up event listeners
    clearAllBtn.addEventListener('click', handleClearAll);

    function loadActiveSessions() {
        chrome.storage.local.get(null, (data) => {
            const sessions = [];
            const now = Date.now();
            
            // Group related data by hostname
            const groupedData = {};
            
            for (const key in data) {
                if (key.endsWith('_timeLimit')) {
                    const hostname = key.replace('_timeLimit', '');
                    if (!groupedData[hostname]) groupedData[hostname] = {};
                    groupedData[hostname].timeLimit = data[key];
                }
                if (key.endsWith('_timeSpent')) {
                    const hostname = key.replace('_timeSpent', '');
                    if (!groupedData[hostname]) groupedData[hostname] = {};
                    groupedData[hostname].timeSpent = data[key];
                }
                if (key.endsWith('_startTime')) {
                    const hostname = key.replace('_startTime', '');
                    if (!groupedData[hostname]) groupedData[hostname] = {};
                    groupedData[hostname].startTime = data[key];
                }
            }

            // Process grouped data into sessions
            for (const hostname in groupedData) {
                const session = groupedData[hostname];
                if (session.timeLimit && session.startTime) {
                    // Check if session is from today
                    const isToday = (now - session.startTime) < 24 * 60 * 60 * 1000;
                    
                    if (isToday) {
                        sessions.push({
                            hostname: hostname,
                            timeLimit: session.timeLimit,
                            timeSpent: session.timeSpent || 0,
                            startTime: session.startTime
                        });
                    }
                }
            }

            displaySessions(sessions);
        });
    }

    function displaySessions(sessions) {
        if (sessions.length === 0) {
            activeSessionsDiv.innerHTML = `
                <div class="no-sessions">
                    <p>No active sessions</p>
                    <p>Visit a social media site to start tracking!</p>
                </div>
            `;
            return;
        }

        activeSessionsDiv.innerHTML = sessions.map(session => {
            const timeRemaining = Math.max(0, session.timeLimit - session.timeSpent);
            const isBlocked = timeRemaining === 0;
            const progress = Math.min(100, (session.timeSpent / session.timeLimit) * 100);
            
            const minutes = Math.floor(timeRemaining / 60);
            const seconds = timeRemaining % 60;
            const timeString = `${minutes}:${seconds.toString().padStart(2, '0')}`;
            
            const totalMinutes = Math.floor(session.timeLimit / 60);
            const spentMinutes = Math.floor(session.timeSpent / 60);

            return `
                <div class="session-item">
                    <div class="session-info">
                        <h4>${formatHostname(session.hostname)}</h4>
                        <p>${spentMinutes}/${totalMinutes} minutes used</p>
                        ${isBlocked ? 
                            '<p style="color: #c62828; font-weight: 600;">⚠️ Time limit reached</p>' : 
                            `<p>⏰ ${timeString} remaining</p>`
                        }
                    </div>
                    <div class="session-status ${isBlocked ? 'blocked' : 'active'}">
                        ${isBlocked ? 'BLOCKED' : 'ACTIVE'}
                    </div>
                </div>
            `;
        }).join('');
    }

    function formatHostname(hostname) {
        // Remove common prefixes and make it more readable
        return hostname
            .replace(/^www\./, '')
            .replace(/\.com$/, '')
            .split('.')
            .map(part => part.charAt(0).toUpperCase() + part.slice(1))
            .join(' ');
    }

    function handleClearAll() {
        if (confirm('Are you sure you want to clear all active sessions? This will reset all time limits.')) {
            chrome.storage.local.clear(() => {
                activeSessionsDiv.innerHTML = `
                    <div class="no-sessions">
                        <p>All sessions cleared!</p>
                        <p>Visit a social media site to start tracking again.</p>
                    </div>
                `;
                
                // Show success message
                showTemporaryMessage('✅ All sessions cleared successfully!');
            });
        }
    }

    function showTemporaryMessage(message) {
        const messageDiv = document.createElement('div');
        messageDiv.style.cssText = `
            position: fixed;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            background: #4caf50;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 14px;
            font-weight: 500;
            z-index: 1000;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
        `;
        messageDiv.textContent = message;
        document.body.appendChild(messageDiv);

        setTimeout(() => {
            messageDiv.remove();
        }, 3000);
    }

    // Refresh sessions every 5 seconds if popup is open
    setInterval(loadActiveSessions, 5000);
});