@echo off
echo.
echo ========================================
echo   🚫 Social Media Blocker Extension
echo ========================================
echo.
echo Starting Chrome with extension directory...
echo.

REM Get the current directory
set CURRENT_DIR=%~dp0

REM Check if Chrome is installed in common locations
if exist "C:\Program Files\Google\Chrome\Application\chrome.exe" (
    set CHROME_PATH="C:\Program Files\Google\Chrome\Application\chrome.exe"
) else if exist "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" (
    set CHROME_PATH="C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"
) else (
    echo Chrome not found in standard locations.
    echo Please manually open Chrome and go to chrome://extensions/
    echo Then enable Developer Mode and load this folder: %CURRENT_DIR%
    pause
    exit /b
)

echo Found Chrome at: %CHROME_PATH%
echo Extension folder: %CURRENT_DIR%
echo.
echo Instructions:
echo 1. Chrome will open to the extensions page
echo 2. Enable "Developer mode" (toggle in top-right)
echo 3. Click "Load unpacked"
echo 4. Select this folder: %CURRENT_DIR%
echo 5. Look for the extension icon in your toolbar
echo.

REM Open Chrome to extensions page
start %CHROME_PATH% --new-window "chrome://extensions/"

echo Chrome opened! Follow the instructions above to load the extension.
echo.
echo After loading the extension:
echo - Click the extension icon in your toolbar
echo - Enter a website to block (e.g., facebook.com)
echo - Set a timer (e.g., 1 minute for testing)
echo - Click "Set Block & Timer"
echo - Visit the website to see the timer in action!
echo.
pause
