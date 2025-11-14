# Aura Architecture Documentation

## System Overview

Aura is a privacy-first, serverless emergency alert application for Android. The architecture is designed around three core principles:

1. **Privacy First**: All data processing occurs locally on the device
2. **Zero Server Dependency**: Complete functionality without internet connectivity
3. **Security by Design**: End-to-end encryption for all communications

---

## Architecture Layers

### 1. Presentation Layer

#### UI Framework
- **Technology**: Jetpack Compose
- **Design System**: Material Design 3
- **Architecture Pattern**: MVVM (Model-View-ViewModel)

#### Components

**Screens**
- Dashboard Screen: Main interface with status, timer, and panic button
- Contacts Screen: Manage trusted contacts
- Alerts Screen: View alert history
- Settings Screen: Configure application behavior

**ViewModels**
- DashboardViewModel: Manages dashboard state and user interactions
- ContactsViewModel: Handles contact management operations
- AlertsViewModel: Manages alert history and active alerts
- SettingsViewModel: Coordinates application settings

**State Management**
- Kotlin Flow for reactive state updates
- StateFlow for UI state
- SharedFlow for one-time events
- Compose State for UI composition

### 2. Domain Layer

#### Use Cases

**Alert Use Cases**
- TriggerEmergencyAlertUseCase
- CancelAlertUseCase
- SendLocationUpdateUseCase
- ProcessIncomingAlertUseCase

**Contact Use Cases**
- AddContactUseCase
- RemoveContactUseCase
- UpdateContactUseCase
- ExchangeEncryptionKeysUseCase

**Security Use Cases**
- EncryptMessageUseCase
- DecryptMessageUseCase
- RotateEncryptionKeysUseCase
- VerifyContactIdentityUseCase

#### Business Logic

**Alert Management**
- Alert trigger coordination
- Location tracking coordination
- SMS message formatting
- Alert state management

**Contact Management**
- Contact CRUD operations
- Key exchange workflow
- Contact verification

**Security Management**
- Encryption key lifecycle
- Key storage and retrieval
- Key rotation scheduling

### 3. Data Layer

#### Repository Pattern

**AlertRepository**
```kotlin
interface AlertRepository {
    suspend fun createAlert(alert: AlertLog): Long
    suspend fun getActiveAlerts(): Flow<List<AlertLog>>
    suspend fun updateAlert(alert: AlertLog)
    suspend fun deleteAlert(alertId: Long)
}
```

**ContactRepository**
```kotlin
interface ContactRepository {
    suspend fun addContact(contact: Contact): Long
    suspend fun getAllContacts(): Flow<List<Contact>>
    suspend fun getContact(contactId: Long): Contact?
    suspend fun updateContact(contact: Contact)
    suspend fun deleteContact(contactId: Long)
}
```

**LocationRepository**
```kotlin
interface LocationRepository {
    suspend fun addBreadcrumb(breadcrumb: LocationBreadcrumb)
    suspend fun getBreadcrumbs(alertId: Long): Flow<List<LocationBreadcrumb>>
    suspend fun deleteBreadcrumbs(alertId: Long)
}
```

#### Data Sources

**Local Database (Room + SQLCipher)**
- Contact storage
- Alert log storage
- Location breadcrumb storage
- Audit log storage

**DataStore Preferences**
- Application settings
- User preferences
- Feature flags

**Android Keystore**
- Encryption key storage
- Database passphrase storage
- Hardware-backed security

### 4. Infrastructure Layer

#### Services

**AlertService (Foreground Service)**
```kotlin
Purpose: Coordinate emergency alert sending
Responsibilities:
- Send encrypted SMS to trusted contacts
- Track device location during alert
- Monitor battery level
- Detect user activity
- Send periodic location updates
```

**LocationService (Foreground Service)**
```kotlin
Purpose: Track and share location during emergencies
Responsibilities:
- Obtain GPS coordinates
- Create location breadcrumbs
- Send updates via SMS
- Monitor location accuracy
```

**AccessibilityTriggerService**
```kotlin
Purpose: Detect power button emergency trigger
Responsibilities:
- Monitor accessibility events
- Detect power button press pattern
- Trigger emergency alert
- Provide haptic feedback
```

#### Broadcast Receivers

**SmsReceiver**
```kotlin
Purpose: Process incoming emergency SMS
Responsibilities:
- Intercept SMS messages
- Identify encrypted alerts
- Decrypt message content
- Trigger alert UI
- Store alert in database
```

**BootReceiver**
```kotlin
Purpose: Restore services after device restart
Responsibilities:
- Re-enable active triggers
- Resume active alerts
- Restore notification channels
- Check for pending alerts
```

**GeofenceBroadcastReceiver**
```kotlin
Purpose: Handle geofence events
Responsibilities:
- Detect geofence transitions
- Trigger automated alerts
- Update geofence status
- Log geofence events
```

---

## Data Models

### Core Entities

#### Contact
```kotlin
@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val phoneNumber: String,
    val relationship: String?,
    val encryptionPublicKey: String?,
    val encryptionPrivateKey: String?,
    val isVerified: Boolean = false,
    val addedAt: Long,
    val lastKeyRotation: Long?
)
```

#### AlertLog
```kotlin
@Entity(tableName = "alert_logs")
data class AlertLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val type: AlertType,
    val direction: AlertDirection,
    val contactId: Long?,
    val triggeredAt: Long,
    val latitude: Double?,
    val longitude: Double?,
    val batteryLevel: Int?,
    val activityType: String?,
    val status: AlertStatus,
    val cancelledAt: Long?,
    val resolvedAt: Long?
)
```

#### LocationBreadcrumb
```kotlin
@Entity(tableName = "location_breadcrumbs")
data class LocationBreadcrumb(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val alertId: Long,
    val latitude: Double,
    val longitude: Double,
    val altitude: Double?,
    val accuracy: Float,
    val timestamp: Long,
    val batteryLevel: Int,
    val speed: Float?
)
```

#### AuditLog
```kotlin
@Entity(tableName = "audit_logs")
data class AuditLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val eventType: AuditEventType,
    val description: String,
    val timestamp: Long,
    val severity: AuditSeverity,
    val metadata: String?
)
```

---

## Security Architecture

### Encryption Stack

#### Database Encryption
- **Library**: SQLCipher for Android
- **Algorithm**: AES-256 in CBC mode
- **Key Derivation**: PBKDF2 with SHA-256
- **Key Storage**: Android Keystore (hardware-backed when available)

```kotlin
// Database encryption initialization
val passphrase = EncryptionUtil.getDatabasePassphrase()
val factory = SupportFactory(passphrase)
Room.databaseBuilder(context, AuraDatabase::class.java, "aura.db")
    .openHelperFactory(factory)
    .build()
```

#### Message Encryption
- **Library**: Google Tink
- **Algorithm**: AES-256-GCM (AEAD)
- **Key Exchange**: Diffie-Hellman with QR code verification
- **Authentication**: HMAC-SHA256

```kotlin
// Message encryption
fun encryptMessage(plaintext: String, recipientPublicKey: String): String {
    val aead = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM)
    val ciphertext = aead.getPrimitive(Aead::class.java)
        .encrypt(plaintext.toByteArray(), null)
    return Base64.encodeToString(ciphertext, Base64.NO_WRAP)
}
```

#### Key Management

**Key Generation**
```kotlin
// Generate encryption key pair
fun generateKeyPair(): KeyPair {
    val keyGenerator = KeyPairGenerator.getInstance(
        KeyProperties.KEY_ALGORITHM_EC,
        "AndroidKeyStore"
    )
    keyGenerator.initialize(
        KeyGenParameterSpec.Builder(
            keyAlias,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        ).build()
    )
    return keyGenerator.generateKeyPair()
}
```

**Key Storage**
- All keys stored in Android Keystore
- Hardware-backed on supported devices
- Automatic key attestation
- Secure key deletion

**Key Rotation**
- Automatic rotation every 90 days
- Manual rotation on demand
- Backward compatibility with old keys
- Secure old key archival

---

## Communication Protocol

### SMS Message Format

#### Alert Message Structure
```
AURA_ALERT|{version}|{type}|{encrypted_payload}|{signature}
```

**Components**:
- `AURA_ALERT`: Message identifier
- `version`: Protocol version (currently 1.0)
- `type`: Alert type (EMERGENCY, CHECK_IN, LOCATION_UPDATE)
- `encrypted_payload`: Encrypted JSON data
- `signature`: HMAC signature for authentication

#### Encrypted Payload Format
```json
{
  "senderId": "contact_id_hash",
  "timestamp": 1699999999999,
  "latitude": 37.7749,
  "longitude": -122.4194,
  "altitude": 15.5,
  "accuracy": 10.0,
  "battery": 75,
  "activity": "STILL",
  "message": "Emergency alert triggered"
}
```

### Message Flow

#### Outgoing Alert
1. User triggers emergency alert
2. AlertService collects device data (location, battery, activity)
3. Data encrypted with recipient's public key
4. SMS message formatted with encrypted payload
5. Message signed with sender's private key
6. SMS sent to all trusted contacts
7. Alert logged in local database

#### Incoming Alert
1. SmsReceiver intercepts SMS
2. Message validated (signature verification)
3. Payload decrypted with recipient's private key
4. Alert data extracted and parsed
5. Full-screen alert UI displayed
6. Alert stored in database
7. Notification sent to user

---

## Dependency Injection

### Manual DI Pattern

```kotlin
class AppContainer(private val context: Context) {
    // Database
    private val database: AuraDatabase by lazy {
        AuraDatabase.getInstance(context)
    }
    
    // Repositories
    val contactRepository: ContactRepository by lazy {
        ContactRepositoryImpl(database.contactDao())
    }
    
    val alertRepository: AlertRepository by lazy {
        AlertRepositoryImpl(database.alertLogDao())
    }
    
    // Use Cases
    val triggerAlertUseCase: TriggerEmergencyAlertUseCase by lazy {
        TriggerEmergencyAlertUseCase(alertRepository, contactRepository)
    }
}
```

### ViewModel Factory

```kotlin
class ViewModelFactory(private val appContainer: AppContainer) : 
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            DashboardViewModel::class.java -> {
                DashboardViewModel(
                    appContainer.triggerAlertUseCase,
                    appContainer.alertRepository
                ) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}
```

---

## Background Processing

### WorkManager Integration

**Scheduled Tasks**:
- Key rotation (every 90 days)
- Data cleanup (daily)
- Audit log maintenance (weekly)
- Geofence monitoring (continuous)

```kotlin
// Schedule key rotation
val keyRotationWork = PeriodicWorkRequestBuilder<KeyRotationWorker>(
    90, TimeUnit.DAYS
).build()

WorkManager.getInstance(context).enqueueUniquePeriodicWork(
    "key_rotation",
    ExistingPeriodicWorkPolicy.KEEP,
    keyRotationWork
)
```

### Foreground Services

**Service Lifecycle**:
1. Service started with startForeground()
2. Persistent notification displayed
3. Service performs background work
4. Service stopped when work complete
5. Notification dismissed

**Location Service Example**:
```kotlin
class LocationService : LifecycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(NOTIFICATION_ID, createNotification())
        startLocationTracking()
        return START_STICKY
    }
}
```

---

## Performance Considerations

### Database Optimization

**Indexing Strategy**:
```kotlin
@Entity(
    tableName = "alert_logs",
    indices = [
        Index(value = ["contactId"]),
        Index(value = ["triggeredAt"]),
        Index(value = ["status"])
    ]
)
```

**Query Optimization**:
- Use Flow for reactive queries
- Limit query results with pagination
- Use @Transaction for complex queries
- Avoid N+1 query problems

### Memory Management

**Bitmap Handling**:
- Resize images before encryption
- Use appropriate bitmap configurations
- Recycle bitmaps when done
- Cache decoded bitmaps

**Location Updates**:
- Batch location updates
- Adjust update frequency based on battery
- Stop updates when not needed
- Use passive location provider when possible

### Battery Optimization

**Strategies**:
- Use JobScheduler for deferrable work
- Batch network requests
- Reduce location update frequency
- Use geofencing for location monitoring
- Minimize wake locks

---

## Testing Strategy

### Unit Tests

**Test Coverage**:
- ViewModels: Business logic and state management
- Repositories: Data access and transformation
- Use Cases: Domain logic
- Utilities: Encryption, formatting, validation

```kotlin
@Test
fun `trigger alert creates alert log`() = runBlocking {
    val useCase = TriggerEmergencyAlertUseCase(
        alertRepository = mockAlertRepository,
        contactRepository = mockContactRepository
    )
    
    useCase.execute()
    
    verify(mockAlertRepository).createAlert(any())
}
```

### Integration Tests

**Test Scenarios**:
- Database operations with encryption
- Service communication
- Broadcast receiver handling
- SMS sending and receiving

```kotlin
@Test
fun `encrypted message can be decrypted`() {
    val original = "Emergency alert"
    val encrypted = encryptionUtil.encrypt(original, publicKey)
    val decrypted = encryptionUtil.decrypt(encrypted, privateKey)
    
    assertEquals(original, decrypted)
}
```

### UI Tests

**Test Coverage**:
- User flows (add contact, trigger alert)
- Permission requests
- Navigation
- Error handling

```kotlin
@Test
fun `panic button requires 3 second hold`() {
    composeTestRule.onNodeWithTag("panic_button").performTouchInput {
        down(center)
        advanceEventTime(2000) // 2 seconds
        up()
    }
    
    composeTestRule.onNodeWithText("Alert sent").assertDoesNotExist()
}
```

---

## Build Configuration

### Gradle Modules

**App Module**:
- Application code
- UI components
- Android-specific implementations

**Potential Future Modules**:
- Core: Business logic and domain models
- Data: Repository implementations
- Network: SMS handling (currently in app)

### Build Types

**Debug**:
- Debuggable
- Logging enabled
- No obfuscation
- Test keys for encryption

**Release**:
- Minify enabled
- Obfuscation enabled
- Production encryption keys
- Crash reporting

### ProGuard Rules

```proguard
# Keep encryption classes
-keep class com.aura.emergency.util.EncryptionUtil { *; }

# Keep data models
-keep class com.aura.emergency.data.model.** { *; }

# Keep Room generated classes
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
```

---

## Deployment

### Release Checklist

1. Update version number in build.gradle.kts
2. Update CHANGELOG.md
3. Run all tests (unit, integration, UI)
4. Generate signed APK
5. Test on multiple devices
6. Create GitHub release
7. Upload APK to release
8. Update documentation

### Version Numbering

Format: `MAJOR.MINOR.PATCH`

- **MAJOR**: Breaking changes, major features
- **MINOR**: New features, backward compatible
- **PATCH**: Bug fixes, security updates

---

## Future Enhancements

### Planned Features

**Phase 2**:
- Complete onboarding flow
- Contact management UI
- Key exchange implementation

**Phase 3**:
- Multiple alert triggers
- Complete SMS handling
- Alert reception UI

**Phase 4**:
- Geofencing
- Check-in system
- Advanced settings

### Scalability Considerations

**Database**:
- Partition large tables by date
- Implement data archival
- Add database migration strategy

**Performance**:
- Implement caching layer
- Optimize image handling
- Reduce memory footprint

**Security**:
- Add certificate pinning
- Implement key attestation
- Add root detection

---

**Document Version**: 1.0  
**Last Updated**: November 2024  
**For Aura Version**: 1.0.0
