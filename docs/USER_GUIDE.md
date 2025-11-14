# Aura User Guide

## Table of Contents

1. [Getting Started](#getting-started)
2. [Initial Setup](#initial-setup)
3. [Managing Contacts](#managing-contacts)
4. [Emergency Features](#emergency-features)
5. [Settings and Configuration](#settings-and-configuration)
6. [Privacy and Security](#privacy-and-security)
7. [Troubleshooting](#troubleshooting)

---

## Getting Started

### Welcome to Aura

Aura is a privacy-focused emergency alert application that allows you to communicate with trusted contacts during critical situations. All data is stored locally on your device, and all communications are encrypted.

### First Launch

When you first open Aura, you will be guided through a setup process:

1. **Welcome Screen**: Introduction to Aura's privacy principles
2. **Permissions**: Grant necessary permissions for app functionality
3. **First Contact**: Add at least one trusted contact
4. **Key Exchange**: Securely exchange encryption keys with your contact

---

## Initial Setup

### Required Permissions

Aura requires the following permissions to function properly:

#### SMS Permissions
- **Purpose**: Send and receive encrypted emergency alerts
- **Privacy**: Messages are encrypted before sending
- **When Used**: Only during active emergency alerts

#### Location Permissions
- **Purpose**: Share your location during emergencies
- **Privacy**: Location data never leaves your device except during active alerts
- **When Used**: Only when emergency alert is triggered

#### Notification Permissions
- **Purpose**: Display incoming emergency alerts
- **Privacy**: All notifications are local to your device
- **When Used**: When receiving alerts from trusted contacts

#### Accessibility Service
- **Purpose**: Enable power button emergency trigger
- **Privacy**: Only monitors power button press patterns
- **When Used**: Continuously when feature is enabled

### Granting Permissions

To grant permissions:

1. Open Aura application
2. When prompted, tap "Allow" for each permission
3. For accessibility service:
   - Open Android Settings
   - Navigate to Accessibility
   - Find and enable "Aura Emergency Trigger"
   - Review permissions and tap "Allow"

---

## Managing Contacts

### Adding a Trusted Contact

Trusted contacts receive your emergency alerts. To add a contact:

1. Open Aura
2. Navigate to "Contacts" tab
3. Tap the "+" button
4. Enter contact information:
   - Full name
   - Phone number (must include country code)
   - Relationship (optional: family, friend, colleague)
5. Tap "Save"

### Key Exchange Process

For secure encrypted communication, exchange keys with your contact:

#### Method 1: QR Code Exchange (Recommended)

**In Person:**
1. Open contact details
2. Tap "Exchange Keys"
3. Select "Show QR Code"
4. Have your contact scan the code with their device
5. Scan their QR code when prompted
6. Verify the security code matches
7. Tap "Confirm"

#### Method 2: Manual Verification

**Remote Setup:**
1. Open contact details
2. Tap "Exchange Keys"
3. Select "Manual Exchange"
4. Share your public key via secure channel
5. Enter their public key
6. Verify security code over phone call
7. Tap "Confirm"

### Editing Contact Information

To update contact details:

1. Navigate to Contacts
2. Tap on the contact name
3. Tap "Edit" icon
4. Update information
5. Tap "Save"

### Removing a Contact

To remove a trusted contact:

1. Navigate to Contacts
2. Long-press on contact name
3. Select "Remove Contact"
4. Confirm removal

**Warning**: Removing a contact deletes all encryption keys and alert history with that contact.

---

## Emergency Features

### Panic Button

The panic button sends immediate alerts to all trusted contacts.

#### Using the Panic Button

1. Locate the red panic button on the dashboard
2. Press and hold for 3 seconds
3. Watch the progress indicator fill
4. Hold until alert is sent
5. To cancel: release before 3 seconds

#### What Happens When Activated

1. Encrypted alerts sent to all trusted contacts via SMS
2. Current location captured and encrypted
3. Location tracking begins (updates every 30 seconds)
4. Battery level included in alert
5. Current activity status detected

### Alternative Emergency Triggers

Configure additional ways to trigger emergency alerts:

#### Power Button Trigger

1. Enable in Settings > Triggers
2. Press power button 5 times rapidly
3. Alert activates automatically

**Note**: Requires accessibility service to be enabled.

#### Shake Trigger

1. Enable in Settings > Triggers
2. Shake device vigorously for 3 seconds
3. Alert activates automatically

#### Volume Key Trigger

1. Enable in Settings > Triggers
2. Press Volume Up + Volume Down simultaneously 3 times
3. Alert activates automatically

### Safety Timer

Set a timer to automatically alert contacts if you don't check in.

#### Setting a Safety Timer

1. Tap "Safety Timer" on dashboard
2. Select duration:
   - 30 minutes
   - 1 hour
   - 2 hours
   - 4 hours
   - Custom
3. Tap "Start Timer"
4. Timer counts down on dashboard

#### Checking In

To prevent automatic alert:

1. Open Aura before timer expires
2. Tap "I'm Safe" on timer widget
3. Timer cancels automatically

#### Extending Timer

To add more time:

1. Tap on active timer
2. Select "Extend Timer"
3. Choose additional time
4. Tap "Confirm"

### Location Sharing

During active alerts, your location is automatically shared.

#### Breadcrumb Trail

- Location updates sent every 30 seconds
- Each update includes:
  - GPS coordinates
  - Timestamp
  - Accuracy estimate
  - Battery level
- Continues until alert is cancelled

#### Manual Location Share

Share location without full emergency alert:

1. Navigate to Quick Actions
2. Tap "Share Location"
3. Select duration:
   - 15 minutes
   - 30 minutes
   - 1 hour
   - Until manually stopped
4. Select recipients
5. Tap "Send"

---

## Settings and Configuration

### Trigger Settings

Configure how emergency alerts are activated:

**Power Button**
- Enable/Disable power button trigger
- Set number of presses (3-7)
- Set time window (1-5 seconds)

**Shake Detection**
- Enable/Disable shake trigger
- Adjust sensitivity (low, medium, high)
- Set duration (2-5 seconds)

**Volume Keys**
- Enable/Disable volume key trigger
- Set combination pattern

**Bluetooth Disconnect**
- Enable/Disable Bluetooth trigger
- Select trusted Bluetooth devices
- Set grace period (0-60 seconds)

### Alert Settings

Customize alert behavior:

**Location Updates**
- Update frequency (15s, 30s, 1min, 2min)
- Maximum duration (30min, 1hr, 2hr, unlimited)
- Include altitude data

**Message Content**
- Include battery level
- Include activity status
- Include ambient noise level
- Custom message prefix

**Automatic Actions**
- Auto-enable location tracking
- Auto-capture photo (if safe)
- Auto-record audio (if safe)

### Privacy Settings

Control data retention and privacy:

**Data Retention**
- Keep alert history: 7 days, 30 days, 90 days, 1 year, forever
- Auto-delete location data after: 24 hours, 7 days, 30 days
- Audit log retention: 30 days, 90 days, 1 year

**Encryption**
- View encryption status
- Rotate encryption keys
- Backup encryption keys
- Restore from backup

**Security**
- Enable duress PIN
- Configure fake dashboard
- Set app icon camouflage
- Lock app with biometrics

### Notification Settings

Control how notifications appear:

**Alert Notifications**
- Sound: Default, Emergency Siren, Silent
- Vibration pattern
- LED color (if supported)
- Show on lock screen

**Service Notifications**
- Show location tracking notification
- Show check-in reminders
- Minimize notification priority

---

## Privacy and Security

### Data Storage

All data stored on your device is encrypted:

**Encryption Standard**: AES-256
**Key Storage**: Android Keystore (hardware-backed when available)
**Encrypted Data**:
- Contact information
- Alert history
- Location breadcrumbs
- Audit logs
- Encryption keys

### Message Encryption

All SMS communications are encrypted:

**Algorithm**: AEAD (Authenticated Encryption with Associated Data)
**Library**: Google Tink
**Key Exchange**: Verified QR code or manual verification
**Forward Secrecy**: Supported through key rotation

### No Cloud Services

Aura operates entirely on your device:

- No account registration required
- No data sent to servers
- No analytics or tracking
- No internet required for core functionality
- All processing happens locally

### Security Best Practices

**Recommended Practices**:

1. Use strong device lock screen (PIN, pattern, or biometric)
2. Keep Aura updated to latest version
3. Verify contact identities during key exchange
4. Regularly review trusted contacts list
5. Test emergency features monthly
6. Backup encryption keys securely
7. Enable duress PIN for high-risk situations
8. Review alert history and audit logs periodically

**Key Exchange Verification**:

Always verify security codes when exchanging keys:
- Compare codes in person when possible
- Verify over video call as second choice
- Verify over voice call as last resort
- Never verify via text message or email

---

## Troubleshooting

### Common Issues

#### Alerts Not Sending

**Symptoms**: Panic button pressed but contacts don't receive alerts

**Solutions**:
1. Verify SMS permission is granted
2. Check that contacts have valid phone numbers
3. Ensure device has cellular signal
4. Verify encryption keys are exchanged with contacts
5. Check that contact's device has Aura installed

#### Location Not Sharing

**Symptoms**: Location data not included in alerts

**Solutions**:
1. Grant location permission in Android settings
2. Enable location services on device
3. Check GPS signal strength
4. Verify location permission is set to "Always Allow"

#### Power Button Trigger Not Working

**Symptoms**: Pressing power button doesn't trigger alert

**Solutions**:
1. Enable accessibility service in Android settings
2. Grant accessibility permission to Aura
3. Restart device after enabling accessibility
4. Verify trigger is enabled in Aura settings
5. Check power button press pattern matches configuration

#### Receiving Encrypted Messages as Gibberish

**Symptoms**: Received alerts appear as random characters

**Solutions**:
1. Complete key exchange process with sender
2. Verify both devices have Aura installed
3. Update Aura to latest version on both devices
4. Re-exchange encryption keys

#### App Draining Battery

**Symptoms**: Device battery depleting faster than normal

**Solutions**:
1. Disable unused triggers (shake, Bluetooth)
2. Reduce location update frequency
3. Disable background location when not needed
4. Check for location tracking notification (indicates active alert)
5. Review audit logs for unexpected activity

### Getting Help

If you encounter issues not covered here:

1. Check the GitHub issues page for known issues
2. Review audit logs in Settings > Privacy > Audit Logs
3. Clear app data and reconfigure (last resort)
4. Submit detailed bug report on GitHub

### Resetting Aura

To completely reset the application:

**Warning**: This deletes all data including contacts and encryption keys.

1. Open Android Settings
2. Navigate to Apps > Aura
3. Tap "Storage"
4. Tap "Clear Data"
5. Confirm deletion
6. Reopen Aura to start fresh setup

---

## Appendix

### Glossary

**Encryption Key**: A cryptographic key used to encrypt and decrypt messages
**Key Exchange**: Process of securely sharing encryption keys between devices
**Breadcrumb**: Individual location update sent during active alert
**AEAD**: Authenticated Encryption with Associated Data, a secure encryption method
**QR Code**: Quick Response code used for easy key exchange
**Duress PIN**: Special PIN that shows fake dashboard to hide real emergency data
**Audit Log**: Record of all security and privacy-relevant events

### Technical Specifications

**Minimum Requirements**:
- Android 8.0 (API 26)
- 50 MB storage
- SMS capability
- GPS recommended

**Recommended**:
- Android 13.0 (API 33)
- 100 MB storage
- Hardware-backed keystore
- Active cellular connection

### Privacy Policy Summary

Aura is designed with privacy as the primary concern:

- No data collection by developers
- No analytics or tracking
- No cloud synchronization
- No account required
- All data stays on your device
- Open source for transparency

---

**Document Version**: 1.0  
**Last Updated**: November 2024  
**For Aura Version**: 1.0.0
