# Aura - Privacy-First Emergency Alert App

## Overview
Aura is a **100% serverless, privacy-first emergency alert application** built for Android. It allows users to alert trusted contacts during emergencies through **encrypted SMS messages**. The entire system is locally hosted on the user's device with no cloud servers or central authority.

## What Has Been Built

### ✅ Phase 1: Project Foundation & Core Infrastructure (COMPLETED)

#### 1. **Project Configuration**
- ✅ Updated `build.gradle.kts` with all required dependencies:
  - Room Database with SQLCipher encryption
  - Google Tink for end-to-end encryption
  - Google Play Services (Location, Maps, Activity Recognition)
  - Material 3 with Compose
  - ZXing for QR code generation/scanning
  - Navigation Compose
  - DataStore Preferences
  - Accompanist Permissions

#### 2. **AndroidManifest.xml**
- ✅ Added all required permissions (SMS, Location, Notifications, Accessibility, etc.)
- ✅ Configured main activity and alert reception activity
- ✅ Registered foreground services (AlertService, LocationService)
- ✅ Configured Accessibility Service for power button detection
- ✅ Registered broadcast receivers (SMS, Boot, Geofence)

#### 3. **Data Models** (`data/model/`)
- ✅ `Contact.kt` - Trusted contact entity with encryption support
- ✅ `AlertLog.kt` - Emergency alert records with location, battery, activity data
- ✅ `LocationBreadcrumb.kt` - Location tracking during active alerts
- ✅ `AuditLog.kt` - Event tracking and audit trail

#### 4. **Database Layer** (`data/dao/` & `data/database/`)
- ✅ Room DAOs for all entities with Flow support
- ✅ `AuraDatabase.kt` with SQLCipher AES-256 encryption
- ✅ Database passphrase management using Android Keystore

#### 5. **Encryption Utilities** (`util/EncryptionUtil.kt`)
- ✅ Tink AEAD encryption for SMS messages
- ✅ Key generation and storage in Android Keystore
- ✅ Database encryption passphrase generation
- ✅ Encryption/decryption methods for secure communication

#### 6. **Application Class** (`AuraApplication.kt`)
- ✅ Encrypted database initialization
- ✅ Notification channel creation (Alert, Service, Check-in channels)
- ✅ Application-level resource management

#### 7. **UI Theme & Styling** (`ui/theme/`)
- ✅ `Color.kt` - Complete color palette (Material 3 + custom brand colors)
- ✅ `Type.kt` - Typography scale matching design specs
- ✅ `Theme.kt` - Material 3 theme with dynamic color support
- ✅ Light and Dark mode support

#### 8. **Dashboard Screen** (`ui/dashboard/`)
- ✅ `DashboardViewModel.kt` - State management with Flow
- ✅ `DashboardScreen.kt` - Complete UI implementation:
  - Status card with geofence awareness
  - Safety Timer widget (circular, animated countdown)
  - Panic button (3-second hold with progress indicator)
  - Material 3 Navigation bar
  - Haptic feedback integration

#### 9. **MainActivity** (`MainActivity.kt`)
- ✅ Permission request handling
- ✅ Onboarding check (first-time launch detection)
- ✅ Integration with Dashboard screen
- ✅ ViewModel factory for dependency injection

#### 10. **Service & Receiver Stubs**
- ✅ `AlertService.kt` - Placeholder for alert sending service
- ✅ `LocationService.kt` - Placeholder for location tracking
- ✅ `AccessibilityTriggerService.kt` - Placeholder for power button detection
- ✅ `SmsReceiver.kt` - Placeholder for incoming SMS handling
- ✅ `BootReceiver.kt` - Placeholder for boot events
- ✅ `GeofenceBroadcastReceiver.kt` - Placeholder for geofence events
- ✅ `AlertReceivedActivity.kt` - Placeholder for full-screen alert UI

#### 11. **Resources**
- ✅ `strings.xml` - All UI strings and labels
- ✅ `themes.xml` - Theme definitions including full-screen theme
- ✅ `accessibility_service_config.xml` - Accessibility service configuration

## Current Project Structure

```
app/src/main/
├── AndroidManifest.xml
├── java/com/aura/emergency/
│   ├── AuraApplication.kt
│   ├── MainActivity.kt
│   ├── data/
│   │   ├── dao/
│   │   │   ├── AlertLogDao.kt
│   │   │   ├── AuditLogDao.kt
│   │   │   ├── ContactDao.kt
│   │   │   └── LocationBreadcrumbDao.kt
│   │   ├── database/
│   │   │   └── AuraDatabase.kt
│   │   └── model/
│   │       ├── AlertLog.kt
│   │       ├── AuditLog.kt
│   │       ├── Contact.kt
│   │       └── LocationBreadcrumb.kt
│   ├── receiver/
│   │   ├── BootReceiver.kt
│   │   ├── GeofenceBroadcastReceiver.kt
│   │   └── SmsReceiver.kt
│   ├── service/
│   │   ├── AccessibilityTriggerService.kt
│   │   ├── AlertService.kt
│   │   └── LocationService.kt
│   ├── ui/
│   │   ├── alert/
│   │   │   └── AlertReceivedActivity.kt
│   │   ├── dashboard/
│   │   │   ├── DashboardScreen.kt
│   │   │   └── DashboardViewModel.kt
│   │   └── theme/
│   │       ├── Color.kt
│   │       ├── Theme.kt
│   │       └── Type.kt
│   └── util/
│       └── EncryptionUtil.kt
└── res/
    ├── values/
    │   ├── colors.xml
    │   ├── strings.xml
    │   └── themes.xml
    └── xml/
        └── accessibility_service_config.xml
```

## What Needs to Be Built Next

### 🔨 Phase 2: Onboarding Flow (Priority: HIGH)
- [ ] Welcome splash screen
- [ ] Local-only promise screen
- [ ] Permission request screens
- [ ] Accessibility service setup
- [ ] Add first contact screen
- [ ] Key exchange QR code screen
- [ ] Onboarding completion screen

### 🔨 Phase 3: Contacts Management
- [ ] Contact list screen with RecyclerView/LazyColumn
- [ ] Add contact dialog
- [ ] Contact details screen
- [ ] Key exchange flow implementation
- [ ] QR code scanner integration

### 🔨 Phase 4: Alert Triggering System
- [ ] Implement AccessibilityTriggerService (power button detection)
- [ ] Shake detection service
- [ ] Volume key trigger
- [ ] Bluetooth disconnection detection
- [ ] Panic button integration with AlertService

### 🔨 Phase 5: Alert Services
- [ ] Complete AlertService implementation
- [ ] Location tracking with FusedLocationProviderClient
- [ ] Battery status collection
- [ ] Activity recognition integration
- [ ] Ambient noise measurement
- [ ] Breadcrumb sending logic

### 🔨 Phase 6: SMS Handling
- [ ] SMS encryption/decryption using Tink
- [ ] SMS sending service
- [ ] SMS receiver for incoming alerts
- [ ] Message format handling (encrypted vs plain-text)

### 🔨 Phase 7: Alert Reception
- [ ] Full-screen alert activity with siren
- [ ] Red flashing animation
- [ ] Map integration showing sender location
- [ ] Breadcrumb trail visualization
- [ ] Action buttons (Call, Respond, Mute)

### 🔨 Phase 8: Check-in System
- [ ] Check-in screen UI
- [ ] Quick "I'm Okay" ping
- [ ] Location sharing with duration
- [ ] Scheduled check-in configuration
- [ ] Missed check-in escalation

### 🔨 Phase 9: Settings
- [ ] Settings screen with categories
- [ ] Trigger configuration
- [ ] Stealth features (icon camouflage, duress PIN)
- [ ] Automation settings
- [ ] Privacy controls

### 🔨 Phase 10: Advanced Features
- [ ] Geofencing implementation
- [ ] Safety timer with notifications
- [ ] Audio snapshot recording
- [ ] App icon camouflage switching
- [ ] Duress PIN with fake dashboard

## How to Build

### Prerequisites
- Android Studio Hedgehog or later
- Android SDK 26 (minimum) - 35 (target)
- Kotlin 2.0.21+
- Gradle 8.13.1+

### Build Steps

1. **Clone/Open Project**
   ```bash
   cd c:\Users\Abhay\AndroidStudioProjects\safety_ping
   ```

2. **Sync Gradle**
   - Open project in Android Studio
   - Click "Sync Project with Gradle Files"
   - Wait for dependencies to download

3. **Build APK**
   - Build > Build Bundle(s) / APK(s) > Build APK(s)
   - Or run: `./gradlew assembleDebug`

4. **Run on Device/Emulator**
   - Connect Android device or start emulator
   - Run > Run 'app'
   - Grant required permissions when prompted

## Testing the Dashboard

The dashboard is currently functional with:
- **Status Card** displaying "Status: SAFE"
- **Safety Timer Widget** with start/cancel functionality
- **Panic Button** requiring 3-second hold
- **Navigation Bar** with 4 tabs (placeholders)

### Test Panic Button:
1. Launch app
2. Scroll to bottom
3. Press and hold the red "HOLD FOR HELP" button for 3 seconds
4. Feel haptic feedback increase during hold
5. See progress bar fill across button
6. Release before 3 seconds to cancel

## Known Limitations (To Be Fixed)

1. **Permissions** - Currently requests on launch but doesn't handle denials gracefully
2. **Onboarding** - Skipped for now to show dashboard
3. **Navigation** - Tab clicks don't navigate yet (screens not built)
4. **Timer Dialog** - Clicking timer widget doesn't show duration picker
5. **Alert Triggering** - Panic button doesn't actually send alerts yet
6. **No Contacts** - Contact management not implemented yet

## Security Notes

- **Database Encryption**: All data encrypted with SQLCipher AES-256
- **Key Storage**: Encryption keys stored in Android Keystore (hardware-backed when available)
- **SMS Encryption**: Tink AEAD for end-to-end encrypted messages
- **No Cloud**: Zero server communication, 100% local processing

## License

This project is built according to the Aura App Functional Specification.

## Next Steps

To continue development, focus on:
1. **Onboarding Flow** - Get users started properly
2. **Contact Management** - Core feature for trusted circle
3. **Alert Triggering** - Make the emergency features work
4. **SMS Service** - Enable actual emergency communication

---

**Built with ❤️ using Jetpack Compose and Material 3**
