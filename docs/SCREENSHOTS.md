# Aura Screenshots Reference

This document describes the screenshots that should be included in the documentation to provide users with visual guidance.

---

## Required Screenshots

### 1. Installation and Setup

#### Screenshot: Welcome Screen
**File**: `docs/images/screenshots/01-welcome-screen.png`  
**Description**: First screen users see when launching Aura for the first time  
**Key Elements**:
- Aura logo
- Brief description of privacy-first approach
- "Get Started" button
- Material Design 3 styling

#### Screenshot: Permission Request
**File**: `docs/images/screenshots/02-permissions.png`  
**Description**: Permission request screen showing required permissions  
**Key Elements**:
- List of permissions with explanations
- Why each permission is needed
- "Grant Permissions" button
- Option to review permissions individually

#### Screenshot: Accessibility Setup
**File**: `docs/images/screenshots/03-accessibility-setup.png`  
**Description**: Guide for enabling accessibility service  
**Key Elements**:
- Step-by-step instructions
- Screenshot of Android accessibility settings
- Toggle for Aura Emergency Trigger
- "Continue" button when complete

---

### 2. Main Dashboard

#### Screenshot: Dashboard Overview (Light Mode)
**File**: `docs/images/screenshots/04-dashboard-light.png`  
**Description**: Main dashboard in light theme  
**Key Elements**:
- Status card showing "SAFE" status
- Safety timer widget (inactive state)
- Red panic button with "HOLD FOR HELP" text
- Bottom navigation bar with 4 tabs
- Material Design 3 color scheme

#### Screenshot: Dashboard Overview (Dark Mode)
**File**: `docs/images/screenshots/05-dashboard-dark.png`  
**Description**: Main dashboard in dark theme  
**Key Elements**:
- Same layout as light mode
- Dark background with proper contrast
- Panic button stands out in dark theme
- OLED-friendly colors

#### Screenshot: Panic Button Active
**File**: `docs/images/screenshots/06-panic-button-active.png`  
**Description**: Panic button being pressed with progress indicator  
**Key Elements**:
- Finger pressing button (illustrated)
- Progress bar filling across button
- "Hold for 2 more seconds" text
- Haptic feedback indicator

#### Screenshot: Safety Timer Active
**File**: `docs/images/screenshots/07-safety-timer-active.png`  
**Description**: Dashboard with active safety timer  
**Key Elements**:
- Timer widget showing countdown (e.g., "45:32")
- Circular progress indicator
- "I'm Safe" button visible
- Time remaining clearly displayed

---

### 3. Contact Management

#### Screenshot: Empty Contacts List
**File**: `docs/images/screenshots/08-contacts-empty.png`  
**Description**: Contacts screen when no contacts added  
**Key Elements**:
- Empty state illustration
- "No trusted contacts yet" message
- Large "+" button to add first contact
- Explanation text

#### Screenshot: Contacts List
**File**: `docs/images/screenshots/09-contacts-list.png`  
**Description**: Contacts screen with multiple contacts  
**Key Elements**:
- List of contacts with names
- Phone numbers (partially masked)
- Verification status indicators
- Add contact FAB button
- Search bar at top

#### Screenshot: Add Contact Form
**File**: `docs/images/screenshots/10-add-contact.png`  
**Description**: Form to add new trusted contact  
**Key Elements**:
- Name input field
- Phone number input field
- Relationship dropdown
- "Save" and "Cancel" buttons
- Input validation hints

#### Screenshot: Contact Details
**File**: `docs/images/screenshots/11-contact-details.png`  
**Description**: Detailed view of a single contact  
**Key Elements**:
- Contact name and photo placeholder
- Phone number
- Verification status
- "Exchange Keys" button
- "Edit" and "Remove" options
- Alert history with this contact

---

### 4. Key Exchange Process

#### Screenshot: QR Code Display
**File**: `docs/images/screenshots/12-qr-code-display.png`  
**Description**: Screen showing QR code for key exchange  
**Key Elements**:
- Large QR code centered
- "Have your contact scan this code" instruction
- "Switch to Scan" button
- Security code displayed below QR
- Timer showing QR expiration

#### Screenshot: QR Code Scanner
**File**: `docs/images/screenshots/13-qr-code-scanner.png`  
**Description**: Camera view for scanning contact's QR code  
**Key Elements**:
- Camera viewfinder
- QR code scanning overlay
- "Align QR code within frame" instruction
- "Switch to Show Code" button
- Cancel option

#### Screenshot: Key Verification
**File**: `docs/images/screenshots/14-key-verification.png`  
**Description**: Screen to verify security code match  
**Key Elements**:
- Large security code (e.g., "4827-6391")
- "Verify this code matches your contact's" instruction
- "Codes Match" and "Don't Match" buttons
- Warning about security importance

---

### 5. Alert Screens

#### Screenshot: Alert History
**File**: `docs/images/screenshots/15-alert-history.png`  
**Description**: List of past sent and received alerts  
**Key Elements**:
- Chronological list of alerts
- Alert type icons (sent vs received)
- Timestamp and contact name
- Status indicators (resolved, active, cancelled)
- Filter options

#### Screenshot: Alert Details
**File**: `docs/images/screenshots/16-alert-details.png`  
**Description**: Detailed view of a specific alert  
**Key Elements**:
- Alert type and timestamp
- Contact information
- Location on map
- Battery level at time of alert
- Activity status
- Breadcrumb trail
- Actions taken

#### Screenshot: Incoming Alert (Full Screen)
**File**: `docs/images/screenshots/17-incoming-alert.png`  
**Description**: Full-screen notification for incoming emergency alert  
**Key Elements**:
- Red background (emergency color)
- Contact name and photo
- "EMERGENCY ALERT" text (large)
- Location information
- Time of alert
- Action buttons (Call, Respond, View Location, Mute)
- Continuous visual animation

#### Screenshot: Breadcrumb Trail
**File**: `docs/images/screenshots/18-breadcrumb-trail.png`  
**Description**: Map showing location updates during active alert  
**Key Elements**:
- Map with breadcrumb markers
- Path connecting breadcrumbs
- Timestamps on breadcrumbs
- Current location highlighted
- Battery levels shown
- Zoom controls

---

### 6. Settings

#### Screenshot: Settings Main
**File**: `docs/images/screenshots/19-settings-main.png`  
**Description**: Main settings screen with categories  
**Key Elements**:
- Triggers section
- Alert Settings section
- Privacy & Security section
- Notifications section
- About section
- Material Design list layout

#### Screenshot: Trigger Configuration
**File**: `docs/images/screenshots/20-trigger-settings.png`  
**Description**: Configure alert trigger methods  
**Key Elements**:
- Power Button toggle and settings
- Shake Detection toggle and sensitivity
- Volume Keys toggle
- Bluetooth Disconnect toggle
- Test Trigger button for each

#### Screenshot: Privacy Settings
**File**: `docs/images/screenshots/21-privacy-settings.png`  
**Description**: Privacy and security configuration  
**Key Elements**:
- Data retention settings
- Encryption key management
- Duress PIN configuration
- App icon camouflage option
- Audit log access
- Clear data option

#### Screenshot: Alert Settings
**File**: `docs/images/screenshots/22-alert-settings.png`  
**Description**: Configure how alerts behave  
**Key Elements**:
- Location update frequency slider
- Maximum tracking duration
- Include battery level toggle
- Include activity status toggle
- Custom message field
- Auto-actions toggles

---

### 7. Additional Features

#### Screenshot: Check-in Screen
**File**: `docs/images/screenshots/23-checkin.png`  
**Description**: Quick check-in feature  
**Key Elements**:
- "I'm Okay" large button
- Share location toggle
- Duration picker
- Select recipients
- Send button

#### Screenshot: Geofence Configuration
**File**: `docs/images/screenshots/24-geofence.png`  
**Description**: Set up geofence alerts  
**Key Elements**:
- Map with geofence circle
- Address/location name
- Radius adjustment slider
- "Alert when entering" toggle
- "Alert when leaving" toggle
- Save button

#### Screenshot: Audit Log
**File**: `docs/images/screenshots/25-audit-log.png`  
**Description**: View security and privacy events  
**Key Elements**:
- Chronological list of events
- Event type icons
- Severity indicators
- Timestamp
- Event description
- Filter by severity

---

## Screenshot Guidelines

### Technical Requirements

**Resolution**: 1080x2400 pixels (typical modern Android)  
**Format**: PNG with transparency where applicable  
**Color Space**: sRGB  
**Compression**: Optimized for web (under 500KB each)

### Visual Standards

**Consistency**:
- Use same test data across screenshots
- Consistent contact names and numbers (fictional)
- Same timestamp patterns (fictional but realistic)
- Matching color themes

**Clarity**:
- High contrast for readability
- Clear focus on relevant UI elements
- No personal information in screenshots
- Use placeholder data that looks realistic

**Annotations**:
- Add callout boxes for important features
- Use arrows to highlight key interactions
- Number multi-step processes
- Include brief descriptive captions

### Test Data Standards

**Contact Names**: Use clearly fictional names
- Example: "Alex Johnson", "Sam Smith", "Jordan Davis"

**Phone Numbers**: Use invalid number patterns
- Example: "+1 (555) 0100", "+1 (555) 0200"

**Locations**: Use public landmarks
- Example: "Golden Gate Park", "Central Park"

**Dates/Times**: Use clearly fictional timestamps
- Example: "Jan 15, 2024 10:30 AM"

---

## Screenshot Capture Process

### Using Android Emulator

1. Start Android Emulator with Pixel 6 configuration
2. Install debug APK: `adb install app-debug.apk`
3. Launch application
4. Navigate to desired screen
5. Capture: `adb shell screencap -p /sdcard/screenshot.png`
6. Pull image: `adb pull /sdcard/screenshot.png`
7. Rename according to convention

### Using Physical Device

1. Enable Developer Options on Android device
2. Enable USB Debugging
3. Connect device via USB
4. Install debug APK
5. Navigate to desired screen
6. Capture using device screenshot (Power + Volume Down)
7. Pull via adb or transfer via USB

### Post-Processing

1. Crop to remove status bar if needed (optional)
2. Resize to standard resolution if needed
3. Compress using PNG optimization tools
4. Add annotations if required
5. Save with descriptive filename
6. Add to documentation

---

## Integration with Documentation

### README.md Integration

Add screenshot gallery section:

```markdown
## Screenshots

| Dashboard | Contacts | Alert |
|-----------|----------|-------|
| ![Dashboard](docs/images/screenshots/04-dashboard-light.png) | ![Contacts](docs/images/screenshots/09-contacts-list.png) | ![Alert](docs/images/screenshots/17-incoming-alert.png) |
```

### User Guide Integration

Reference screenshots inline with instructions:

```markdown
### Adding a Contact

1. Navigate to the Contacts tab
2. Tap the "+" button in the bottom right

   ![Add Contact Button](docs/images/screenshots/08-contacts-empty.png)

3. Fill in the contact information
   
   ![Contact Form](docs/images/screenshots/10-add-contact.png)
```

---

## Placeholder Status

**Current Status**: Screenshots not yet captured  
**Reason**: Build environment limitations  
**Next Steps**:
1. Build APK in proper Android development environment
2. Install on emulator or device
3. Capture screenshots following guidelines above
4. Process and optimize images
5. Add to repository
6. Update documentation with image links

---

**Document Version**: 1.0  
**Last Updated**: November 2024
