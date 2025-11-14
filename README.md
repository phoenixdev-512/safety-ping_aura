# Aura

## Privacy-First Emergency Alert Application for Android

Aura is a serverless, privacy-focused emergency alert system designed for Android devices. The application enables users to send encrypted emergency notifications to trusted contacts via SMS without relying on cloud services or central servers. All data processing and encryption occurs locally on the device.

---

## Table of Contents

1. [Overview](#overview)
2. [Key Features](#key-features)
3. [System Requirements](#system-requirements)
4. [Installation](#installation)
5. [User Guide](#user-guide)
6. [Architecture](#architecture)
7. [Security](#security)
8. [Development](#development)
9. [Project Status](#project-status)
10. [Documentation](#documentation)
11. [License](#license)

---

## Overview

Aura provides a secure, private emergency alert system that operates entirely on your device. The application sends encrypted SMS messages to your trusted contacts during emergencies, ensuring your privacy while maintaining reliable communication capabilities.

### Core Principles

- **Privacy First**: All data remains on your device with no cloud synchronization
- **Zero Server Dependency**: Complete functionality without internet connectivity
- **End-to-End Encryption**: All communications encrypted using industry-standard protocols
- **Local Data Storage**: Encrypted database using AES-256 encryption

---

## Key Features

### Current Features

- Dashboard interface with real-time status monitoring
- Emergency panic button with hold-to-activate mechanism
- Safety timer functionality
- Encrypted local database storage
- Material Design 3 user interface
- Dark and light theme support
- Multi-language support framework

### Planned Features

- Trusted contact management
- Multiple alert triggers (power button, shake, volume keys)
- Real-time location sharing during emergencies
- QR code-based key exchange
- Geofencing capabilities
- Scheduled check-in system
- Audio snapshot recording
- Stealth mode options

---

## System Requirements

### Minimum Requirements

- Android 8.0 (API level 26) or higher
- 50 MB available storage
- SMS capability
- Location services

### Recommended Requirements

- Android 13.0 (API level 33) or higher
- 100 MB available storage
- GPS capability
- Hardware-backed Android Keystore support

### Required Permissions

- SMS (send and receive)
- Location (fine and coarse)
- Notifications
- Accessibility services
- Foreground services
- Boot receiver

---

## Installation

### For End Users

#### Method 1: Install from APK

1. Download the latest APK file from the releases page
2. Enable "Install from Unknown Sources" in Android settings
3. Open the downloaded APK file
4. Follow the installation prompts
5. Grant necessary permissions when prompted

#### Method 2: Build from Source

Requirements:
- Android Studio Hedgehog (2023.1.1) or later
- JDK 11 or higher
- Android SDK with API level 35

Steps:

```bash
# Clone the repository
git clone https://github.com/phoenixdev-512/safety-ping_aura.git
cd safety-ping_aura

# Open in Android Studio
# File > Open > Select the project directory

# Sync Gradle dependencies
# Android Studio will prompt automatically

# Build the APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug
```

---

## User Guide

### Initial Setup

#### First Launch

1. Launch the Aura application
2. Grant required permissions:
   - SMS access for emergency alerts
   - Location access for position sharing
   - Notification access for alert delivery
   - Accessibility service for trigger detection
3. Complete the initial setup wizard
4. Configure your first trusted contact

#### Adding Trusted Contacts

1. Navigate to Contacts section
2. Tap "Add Contact" button
3. Enter contact information:
   - Name
   - Phone number
   - Relationship (optional)
4. Perform key exchange:
   - Generate QR code or
   - Scan contact's QR code
5. Verify contact details
6. Save contact

### Using Emergency Features

#### Panic Button

The panic button provides immediate emergency alert capability:

1. Locate the red emergency button on the dashboard
2. Press and hold for 3 seconds
3. Progress indicator shows activation status
4. Release before completion to cancel
5. Upon activation, encrypted alerts sent to all trusted contacts

#### Safety Timer

Configure periodic check-ins to ensure safety:

1. Tap the Safety Timer widget on dashboard
2. Set desired duration
3. Start timer
4. System will notify contacts if timer expires without check-in
5. Cancel or extend timer as needed

#### Location Sharing

During an active alert, Aura automatically:

1. Captures current GPS coordinates
2. Encrypts location data
3. Sends periodic updates (breadcrumbs) to trusted contacts
4. Continues until alert is cancelled

### Managing Alerts

#### Receiving Alerts

When receiving an emergency alert from a trusted contact:

1. Full-screen notification appears
2. Alert details display:
   - Contact name
   - Location (if available)
   - Time of alert
   - Battery level
3. Available actions:
   - Call contact directly
   - Send response
   - View location on map
   - Mute alert

#### Alert History

Access previous alerts:

1. Navigate to Alert Log section
2. View chronological list of sent and received alerts
3. Tap any alert for detailed information
4. Review location history and breadcrumbs

### Settings and Configuration

#### Alert Triggers

Configure multiple alert activation methods:

1. Open Settings > Triggers
2. Enable desired trigger methods:
   - Power button (rapid presses)
   - Shake detection
   - Volume key combination
   - Bluetooth disconnection
3. Adjust sensitivity for each trigger
4. Test triggers before relying on them

#### Privacy Settings

Customize privacy controls:

1. Navigate to Settings > Privacy
2. Configure:
   - Data retention period
   - Automatic data deletion
   - Encryption key rotation
   - Audit log detail level
3. Review security status
4. Manage encryption keys

---

## Architecture

### System Components

#### Data Layer

**Database**
- Room persistence library with SQLCipher encryption
- AES-256 encryption for all stored data
- Entities: Contacts, AlertLog, LocationBreadcrumb, AuditLog

**Data Access Objects (DAOs)**
- ContactDao: Trusted contact management
- AlertLogDao: Emergency alert records
- LocationBreadcrumbDao: Location tracking history
- AuditLogDao: System event logging

#### Security Layer

**Encryption**
- Google Tink AEAD for message encryption
- Android Keystore for key management
- Hardware-backed encryption when available
- Automatic key rotation support

#### Service Layer

**Foreground Services**
- AlertService: Emergency alert coordination
- LocationService: GPS tracking during alerts

**Background Receivers**
- SmsReceiver: Incoming alert processing
- BootReceiver: Service restoration after restart
- GeofenceBroadcastReceiver: Location-based automation

**Accessibility Service**
- AccessibilityTriggerService: Power button detection

#### Presentation Layer

**UI Components**
- Jetpack Compose modern UI framework
- Material Design 3 components
- MVVM architecture pattern
- Reactive state management with Flow

### Project Structure

```
app/src/main/
├── AndroidManifest.xml
├── java/com/aura/emergency/
│   ├── AuraApplication.kt           # Application initialization
│   ├── MainActivity.kt               # Main entry point
│   ├── data/
│   │   ├── dao/                      # Data access objects
│   │   ├── database/                 # Database configuration
│   │   └── model/                    # Data entities
│   ├── receiver/                     # Broadcast receivers
│   ├── service/                      # Background services
│   ├── ui/                           # User interface
│   │   ├── alert/                    # Alert screens
│   │   ├── dashboard/                # Main dashboard
│   │   └── theme/                    # UI theme configuration
│   └── util/                         # Utility classes
└── res/                              # Resources
    ├── values/                       # Strings, colors, themes
    └── xml/                          # Configuration files
```

---

## Security

### Encryption Standards

**Database Encryption**
- Algorithm: AES-256 via SQLCipher
- Key storage: Android Keystore (hardware-backed when available)
- Automatic encryption for all persistent data

**Message Encryption**
- Library: Google Tink
- Algorithm: AEAD (Authenticated Encryption with Associated Data)
- Unique encryption keys per contact pair
- Forward secrecy through key rotation

**Key Management**
- Android Keystore system for key storage
- Hardware-backed security on supported devices
- Automatic key generation and rotation
- Secure key exchange via QR codes

### Privacy Features

**Data Minimization**
- Only essential data collected
- Configurable data retention periods
- Automatic data expiration
- Manual data deletion available

**No External Communication**
- Zero cloud server dependencies
- No analytics or tracking
- All processing occurs on-device
- SMS-only communication protocol

**Audit Trail**
- Comprehensive event logging
- Tamper-evident audit logs
- Encrypted log storage
- User-accessible audit records

### Security Best Practices

For Users:
1. Keep application updated
2. Use strong device lock screen
3. Verify contact identities during key exchange
4. Regularly review trusted contacts
5. Test alert system periodically
6. Backup encryption keys securely

For Developers:
1. Follow secure coding guidelines
2. Regular security audits
3. Dependency vulnerability scanning
4. Code obfuscation in release builds
5. Secure key rotation implementation

---

## Development

### Build Configuration

**Gradle Configuration**
- Build Tool Version: 8.13.1
- Kotlin Version: 2.0.21
- Compile SDK: 35
- Target SDK: 35
- Minimum SDK: 26

**Dependencies**
- AndroidX Core KTX
- Jetpack Compose with Material 3
- Room Database with SQLCipher
- Google Tink Encryption
- Google Play Services (Location, Maps, Activity Recognition)
- ZXing for QR codes
- Navigation Compose
- DataStore Preferences
- Coil for image loading

### Building the Project

#### Debug Build

```bash
./gradlew assembleDebug
```

Output: `app/build/outputs/apk/debug/app-debug.apk`

#### Release Build

```bash
./gradlew assembleRelease
```

Note: Configure signing key in `app/build.gradle.kts` before release build.

### Running Tests

```bash
# Unit tests
./gradlew test

# Instrumentation tests
./gradlew connectedAndroidTest
```

### Code Style

- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Document public APIs with KDoc
- Maintain consistent indentation
- Limit line length to 120 characters

---

## Project Status

### Completed Components

**Phase 1: Foundation**
- Project configuration and dependency management
- Android manifest with permissions and service declarations
- Data models and database schema
- Database encryption implementation
- Encryption utilities for secure communication
- Application initialization and configuration
- UI theme and styling (Material 3)
- Dashboard screen with basic functionality
- Main activity with permission handling
- Service and receiver infrastructure

### In Development

**Phase 2: Onboarding Flow**
- Welcome and introduction screens
- Permission request workflow
- Initial contact setup
- Key exchange process

**Phase 3: Contact Management**
- Contact list interface
- Add/edit contact functionality
- QR code key exchange
- Contact verification

### Planned Development

**Phase 4: Alert System**
- Alert trigger implementations
- SMS encryption and sending
- Alert reception and processing
- Location tracking integration

**Phase 5: Advanced Features**
- Geofencing
- Check-in system
- Settings interface
- Stealth features

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

The project is developed according to the Aura App Functional Specification with a focus on privacy, security, and user safety.

---

## Documentation

Comprehensive documentation is available in the `docs/` directory:

### For Users

- **[Quick Start Guide](docs/QUICKSTART.md)**: Get up and running in 5 minutes
  - Installation instructions
  - Initial setup steps
  - Basic usage guide
  - Testing your setup
  - Quick reference

- **[User Guide](docs/USER_GUIDE.md)**: Complete guide for installing, configuring, and using Aura
  - Initial setup and permissions
  - Managing trusted contacts
  - Using emergency features
  - Settings and configuration
  - Privacy and security information
  - Troubleshooting common issues

### For Developers

- **[Architecture Documentation](docs/ARCHITECTURE.md)**: Technical architecture and design
  - System architecture overview
  - Data models and database schema
  - Security architecture and encryption
  - Service and component details
  - Communication protocols
  - Testing strategy

- **[Contributing Guide](docs/CONTRIBUTING.md)**: Guidelines for contributing to the project
  - Development setup instructions
  - Coding standards and best practices
  - Testing requirements
  - Pull request process
  - Review guidelines

### Additional Resources

- **[Screenshots Reference](docs/SCREENSHOTS.md)**: Visual documentation guide
  - Required screenshots for documentation
  - Screenshot capture guidelines
  - Test data standards

- **[Changelog](CHANGELOG.md)**: Version history and release notes
  - All notable changes to the project
  - Version history and release schedule

- **[Security Policy](SECURITY.md)**: Security information and reporting
  - Supported versions
  - How to report vulnerabilities
  - Security best practices
  - Known security considerations

---

## Support and Contact

For technical support, bug reports, or feature requests, please use the GitHub issue tracker.

**Version**: 1.0.0  
**Last Updated**: November 2024  
**Platform**: Android 8.0+
