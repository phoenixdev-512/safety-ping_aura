# Aura Quick Start Guide

Get started with Aura in minutes. This guide provides the essential steps to install and begin using the emergency alert application.

---

## Prerequisites

Before you begin, ensure you have:

- Android device running Android 8.0 or higher
- Active cellular service with SMS capability
- At least one trusted contact with a phone number
- 50 MB of available storage space

---

## Installation

### Option 1: Install Pre-built APK (Recommended)

1. Download the latest APK from the [Releases](https://github.com/phoenixdev-512/safety-ping_aura/releases) page
2. Open the downloaded file on your Android device
3. If prompted, enable "Install from Unknown Sources" in your device settings
4. Follow the on-screen installation prompts
5. Tap "Install" to complete the installation

### Option 2: Build from Source

```bash
# Clone the repository
git clone https://github.com/phoenixdev-512/safety-ping_aura.git
cd safety-ping_aura

# Build debug APK
./gradlew assembleDebug

# Install to connected device
adb install app/build/outputs/apk/debug/app-debug.apk
```

---

## Initial Setup (5 Minutes)

### Step 1: Launch Aura

1. Open Aura from your app drawer
2. Review the welcome screen
3. Tap "Get Started"

### Step 2: Grant Permissions

Aura requires several permissions for core functionality:

1. **SMS Permission**: Tap "Allow" to enable emergency alerts via SMS
2. **Location Permission**: Tap "Allow" then select "Allow all the time"
3. **Notification Permission**: Tap "Allow" to receive incoming alerts

**Important**: All permissions are required for full functionality.

### Step 3: Enable Accessibility Service (Optional but Recommended)

For power button emergency trigger:

1. When prompted, tap "Enable Accessibility"
2. Navigate to Settings > Accessibility > Aura
3. Toggle "Use Aura" to ON
4. Review permissions and tap "Allow"
5. Return to Aura app

**Note**: This enables triggering alerts by pressing the power button 5 times rapidly.

### Step 4: Add Your First Contact

1. Tap "Add Trusted Contact"
2. Enter contact information:
   - **Name**: Full name of your trusted contact
   - **Phone Number**: Include country code (e.g., +1 555-0100)
   - **Relationship**: Optional (Family, Friend, etc.)
3. Tap "Save"

### Step 5: Exchange Encryption Keys

For secure communication, exchange keys with your contact:

**In Person (Recommended)**:
1. Open the contact you just added
2. Tap "Exchange Keys"
3. Select "Show QR Code"
4. Have your contact scan the code with their Aura app
5. Scan their QR code when prompted
6. Verify the security code matches on both devices
7. Tap "Confirm"

**Remote Setup**:
1. Open the contact
2. Tap "Exchange Keys"
3. Select "Manual Exchange"
4. Share your public key via secure channel
5. Enter their public key
6. Verify security code over phone call
7. Tap "Confirm"

---

## Basic Usage

### Send Emergency Alert

**Method 1: Panic Button**
1. Open Aura
2. Scroll to the red panic button
3. Press and hold for 3 seconds
4. Alert automatically sent to all trusted contacts

**Method 2: Power Button (if enabled)**
1. Press power button 5 times rapidly
2. Feel haptic feedback confirmation
3. Alert automatically sent

### Set Safety Timer

1. Open Aura dashboard
2. Tap "Safety Timer" widget
3. Select duration (30 min, 1 hour, 2 hours, or custom)
4. Tap "Start Timer"
5. Check in before timer expires by tapping "I'm Safe"

### Receive an Alert

When you receive an emergency alert:

1. Full-screen notification appears automatically
2. Review alert details (who, where, when)
3. Available actions:
   - **Call**: Call the contact directly
   - **Respond**: Send a response message
   - **View Map**: See their location
   - **Mute**: Silence alert sound

---

## Essential Settings

### Configure Alert Triggers

1. Open Aura
2. Navigate to Settings > Triggers
3. Enable desired trigger methods:
   - Power Button (5 rapid presses)
   - Shake Detection
   - Volume Keys
4. Adjust sensitivity as needed
5. Test each trigger

### Adjust Privacy Settings

1. Navigate to Settings > Privacy
2. Configure:
   - **Data Retention**: How long to keep alert history
   - **Auto-Delete**: Automatic cleanup schedule
3. Review encryption key status
4. Enable duress PIN for high-risk situations

---

## Testing Your Setup

Before relying on Aura in an emergency, test the system:

### Test Checklist

1. **Add Contact**: Successfully add at least one contact
2. **Key Exchange**: Complete key exchange process
3. **Send Test Alert**: Use panic button to send test alert
4. **Verify Receipt**: Confirm contact receives encrypted alert
5. **Verify Decryption**: Confirm contact can read alert
6. **Check Location**: Verify location is included in alert
7. **Test Triggers**: Try alternative trigger methods
8. **Receive Alert**: Have contact send you a test alert

**Important**: Inform contacts when sending test alerts to avoid confusion.

---

## Common Issues

### Alert Not Sending

**Problem**: Pressed panic button but contact didn't receive alert

**Solutions**:
- Verify SMS permission is granted
- Check cellular signal strength
- Confirm contact phone number is correct
- Ensure key exchange is complete
- Verify contact has Aura installed

### Location Not Included

**Problem**: Alert sent without location data

**Solutions**:
- Grant location permission (Settings > Apps > Aura > Permissions)
- Enable location services on device
- Set permission to "Allow all the time"
- Ensure GPS is enabled

### Power Button Not Working

**Problem**: Pressing power button doesn't trigger alert

**Solutions**:
- Enable accessibility service (Settings > Accessibility > Aura)
- Grant accessibility permission
- Restart device after enabling
- Verify trigger is enabled in Aura settings
- Check press pattern (5 times within 2 seconds)

---

## Next Steps

Now that you have Aura set up:

1. **Add More Contacts**: Build your trusted circle (3-5 contacts recommended)
2. **Explore Features**: Try safety timer, check-in, location sharing
3. **Configure Settings**: Customize triggers and notifications
4. **Read Full Guide**: Review the [User Guide](docs/USER_GUIDE.md) for advanced features
5. **Regular Testing**: Test your setup monthly to ensure reliability

---

## Getting Help

If you need assistance:

1. **User Guide**: See [docs/USER_GUIDE.md](docs/USER_GUIDE.md) for detailed instructions
2. **Troubleshooting**: Check common issues section above
3. **GitHub Issues**: Search existing issues or create a new one
4. **Documentation**: Review all documentation in `docs/` directory

---

## Important Reminders

### Privacy

- All data stays on your device
- No cloud servers or accounts required
- Messages are encrypted end-to-end
- No analytics or tracking

### Security

- Use strong device lock screen
- Verify contacts during key exchange
- Keep Aura updated
- Test regularly

### Emergency Use

- Aura complements, not replaces, traditional emergency services (911)
- Always call 911 for immediate life-threatening emergencies
- Use Aura to alert trusted contacts who can provide assistance
- Test your setup before relying on it

---

## Quick Reference

### Panic Button
Press and hold red button for 3 seconds

### Power Button Trigger  
Press power button 5 times rapidly

### Safety Timer
Dashboard > Safety Timer > Set Duration > Start

### Add Contact
Contacts tab > + button > Enter info > Save

### Exchange Keys
Contact details > Exchange Keys > Show QR / Scan QR

### View Alerts
Alerts tab > Select alert > View details

### Settings
Dashboard > Settings icon > Configure options

---

**Congratulations!** You are now ready to use Aura for emergency communications.

**Remember**: Test your setup regularly and keep your trusted contacts informed about the system.

---

**Version**: 1.0.0  
**Last Updated**: November 2024  
**For**: First-time users
