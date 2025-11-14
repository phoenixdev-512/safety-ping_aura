# Changelog

All notable changes to the Aura project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Planned
- Onboarding flow implementation
- Contact management user interface
- QR code key exchange
- Multiple alert trigger implementations
- Complete SMS handling system
- Alert reception full-screen UI
- Geofencing capabilities
- Check-in system
- Advanced settings interface
- Stealth mode features

## [1.0.0] - 2024-11-14

### Added
- Initial project foundation and core infrastructure
- Android Gradle Plugin configuration with all required dependencies
- Room Database with SQLCipher AES-256 encryption
- Google Tink for end-to-end encrypted messaging
- Material Design 3 UI theme with dark mode support
- Dashboard screen with status monitoring
- Emergency panic button with 3-second hold mechanism
- Safety timer widget with countdown functionality
- Data models for Contact, AlertLog, LocationBreadcrumb, and AuditLog
- Database DAOs with Flow support for reactive queries
- Encrypted database implementation using SQLCipher
- Encryption utilities using Google Tink AEAD
- Android Keystore integration for secure key storage
- Application class with notification channel setup
- Main activity with permission request handling
- Service stubs for AlertService, LocationService, and AccessibilityTriggerService
- Broadcast receivers for SMS, Boot, and Geofence events
- Alert reception activity stub for incoming alerts
- Complete string resources for all UI elements
- Accessibility service configuration
- Comprehensive documentation suite
  - Professional README with installation and usage guides
  - Detailed User Guide
  - Architecture documentation
  - Contributing guidelines
  - Screenshots reference guide

### Security
- AES-256 database encryption with SQLCipher
- AEAD encryption for SMS messages using Google Tink
- Android Keystore for hardware-backed key storage
- Zero cloud dependency architecture
- Local-only data processing

### Technical Specifications
- Minimum Android SDK: 26 (Android 8.0)
- Target Android SDK: 35 (Android 14)
- Kotlin version: 2.0.21
- Android Gradle Plugin: 8.6.0
- Gradle: 8.13

### Dependencies
- AndroidX Core KTX 1.15.0
- Jetpack Compose with Material 3
- Room Database 2.6.1
- SQLCipher 4.5.4
- Google Tink 1.12.0
- Google Play Services Location 21.1.0
- Google Play Services Maps 18.2.0
- ZXing 3.5.3
- Navigation Compose 2.8.5
- DataStore Preferences 1.1.1
- Accompanist Permissions 0.32.0
- Coil 2.5.0

## Version History

### Version Number Format

Aura follows [Semantic Versioning](https://semver.org/):
- MAJOR version for incompatible API changes
- MINOR version for added functionality in a backward compatible manner
- PATCH version for backward compatible bug fixes

### Release Schedule

- Major releases: As needed for significant features
- Minor releases: Monthly or when new features are complete
- Patch releases: As needed for critical bug fixes

---

**Note**: This is a privacy-focused, serverless emergency alert application. All data processing occurs locally on the device. No telemetry or usage data is collected.

[Unreleased]: https://github.com/phoenixdev-512/safety-ping_aura/compare/v1.0.0...HEAD
[1.0.0]: https://github.com/phoenixdev-512/safety-ping_aura/releases/tag/v1.0.0
