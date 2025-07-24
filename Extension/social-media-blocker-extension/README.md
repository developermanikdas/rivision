# 🚫 Social Media Blocker - Chrome Extension

**Take control of your social media usage with automatic detection and full-screen blocking.**

A powerful Chrome extension that automatically detects when you visit social media platforms and helps you set healthy time limits. When your limit is reached, the extension completely blocks the site with a full-screen overlay, encouraging healthier digital habits.

## ✨ Key Features

### 🎯 **Automatic Detection**
- Instantly detects when you visit popular social media platforms
- No manual setup required - just visit any social media site
- Supports Facebook, Instagram, Twitter/X, TikTok, YouTube, LinkedIn, Reddit, and more

### ⏰ **Smart Time Management**
- Set custom time limits (1-180 minutes) for each platform
- Background timer tracks usage only when actively browsing
- Daily limits reset automatically at midnight

### 🛡️ **Full-Screen Blocking**
- Complete site blocking when time limits are reached
- Impossible to bypass - covers entire screen
- Motivational messages to encourage productive activities

### 📊 **Clean Dashboard**
- View all active sessions in one place
- Real-time progress tracking
- Easy session management and cleanup

## 🚀 How It Works

1. **Visit Social Media**: Navigate to any supported social media platform
2. **Set Your Limit**: A popup appears asking how long you want to spend (1-180 minutes)
3. **Browse Normally**: Timer runs silently in the background while you browse
4. **Time's Up**: Full-screen block appears when your limit is reached
5. **Stay Productive**: Choose to finish your session or extend time mindfully

## 📱 Supported Platforms

- **Facebook** (`facebook.com`)
- **Instagram** (`instagram.com`) 
- **Twitter/X** (`twitter.com`, `x.com`)
- **TikTok** (`tiktok.com`)
- **YouTube** (`youtube.com`)
- **LinkedIn** (`linkedin.com`)
- **Reddit** (`reddit.com`)
- **Discord** (`discord.com`)
- **Pinterest** (`pinterest.com`)
- **Snapchat** (`snapchat.com`)
- **Twitch** (`twitch.tv`)

## 🎨 Chrome Store Ready Features

### Privacy-First Design
- ✅ **Local Storage Only** - All data stays on your device
- ✅ **No External Servers** - No data sent anywhere
- ✅ **Minimal Permissions** - Only accesses social media sites you visit
- ✅ **No Tracking** - Completely private and secure

### User Experience
- ✅ **Intuitive Interface** - Clean, modern design
- ✅ **Zero Configuration** - Works immediately after installation
- ✅ **Non-Intrusive** - Only appears when needed
- ✅ **Motivational** - Encourages healthy habits

### Technical Excellence
- ✅ **Lightweight** - Minimal impact on browser performance
- ✅ **Reliable** - Robust error handling and edge case management
- ✅ **Secure** - Content Security Policy compliant
- ✅ **Accessible** - Follows web accessibility guidelines

## 📦 Installation Instructions

### For Development/Testing:
1. Download or clone this repository
2. Open Chrome and go to `chrome://extensions/`
3. Enable "Developer mode" (toggle in top-right)
4. Click "Load unpacked" and select the extension folder
5. The extension is now active - visit any social media site to start!

### For Chrome Web Store:
*(Coming soon - extension will be available for direct download)*

## 🎯 Usage Tips

### Setting Effective Limits
- **Start Small**: Begin with 15-30 minute limits
- **Be Realistic**: Set achievable goals you can stick to
- **Consider Purpose**: Different limits for different platforms

### Making It Work
- **Be Honest**: Don't constantly extend time limits
- **Use Alternatives**: Have other activities ready when blocked
- **Review Regularly**: Adjust limits based on your goals

## � Technical Details

### File Structure
```
social-media-blocker-extension/
├── manifest.json              # Extension configuration
├── README.md                  # Documentation
├── icons/                     # Extension icons
│   ├── icon16.png
│   ├── icon48.png
│   └── icon128.png
└── src/
    ├── background/
    │   └── background.js      # Background service worker
    ├── content/
    │   └── content.js         # Content script for blocking
    └── popup/
        ├── popup.html         # Extension popup interface
        ├── popup.css          # Popup styling
        └── popup.js           # Popup functionality
```

### Key Technologies
- **Manifest V3** - Latest Chrome extension standard
- **Service Workers** - Efficient background processing
- **Content Scripts** - Direct page interaction
- **Chrome Storage API** - Secure local data storage

## 🔒 Privacy & Security

This extension is designed with privacy as the top priority:

- **No Data Collection**: We don't collect, store, or transmit any personal data
- **Local Processing**: All calculations happen on your device
- **Minimal Permissions**: Only requests access to social media sites
- **Open Source**: Code is transparent and auditable
- **No Analytics**: No tracking pixels, analytics, or telemetry

## 🤝 Contributing

We welcome contributions! If you'd like to improve the extension:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🌟 Why Use Social Media Blocker?

In today's digital world, it's easy to lose track of time on social media. This extension helps you:

- **Increase Productivity**: Spend more time on meaningful activities
- **Improve Focus**: Reduce digital distractions during work/study
- **Better Sleep**: Limit late-night social media browsing  
- **Mindful Usage**: Become more aware of your digital habits
- **Work-Life Balance**: Create boundaries between personal and productive time

---

**Ready to take control of your digital life? Install Social Media Blocker today! 🎯**