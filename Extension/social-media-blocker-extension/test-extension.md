# 🧪 Testing Guide for Social Media Blocker Extension

## Quick Test Steps

### 1. Install Extension
1. Open Chrome and go to `chrome://extensions/`
2. Enable "Developer mode" (toggle in top-right)
3. Click "Load unpacked"
4. Select this folder: `social-media-blocker-extension`

### 2. Basic Functionality Test
1. **Click extension icon** in Chrome toolbar
2. **Enter test website**: `facebook.com`
3. **Set timer**: `1` minute
4. **Click**: "⏰ Set Block & Timer"
5. **Verify**: Success message and status shows "Currently blocking: facebook.com"

### 3. Timer Test
1. **Visit**: `https://facebook.com`
2. **Look for**: Timer display in top-right corner
3. **Observe**: Timer counting down from 1:00
4. **Wait**: For timer to reach 0:00
5. **Check**: Browser notification appears
6. **Verify**: Timer shows overtime in red

### 4. Reset Test
1. **Go back** to extension popup
2. **Click**: "🔄 Reset Timer"
3. **Visit**: Facebook again
4. **Verify**: Timer resets to 1:00

### 5. Clear Test
1. **In popup**, click "❌ Clear Block"
2. **Verify**: Status shows "No website currently blocked"
3. **Visit**: Facebook
4. **Confirm**: No timer appears

## Expected Results

✅ **Extension loads** without errors
✅ **Popup opens** with clean interface
✅ **Settings save** and persist
✅ **Timer appears** on blocked websites
✅ **Notifications work** when time expires
✅ **Reset/Clear functions** work properly

## Test Different Websites

Try these popular sites:
- `facebook.com`
- `instagram.com`
- `twitter.com`
- `youtube.com`
- `reddit.com`

## Troubleshooting

If something doesn't work:
1. Check browser console (F12) for errors
2. Go to `chrome://extensions/` and reload the extension
3. Make sure notifications are allowed in Chrome settings
4. Try different websites

## Performance Test

- Set 30-minute timer
- Visit blocked site multiple times
- Switch between tabs
- Close/reopen browser
- Verify timer persistence

---

**The extension is now fully functional and ready for use! 🎉**
