package com.aura.emergency.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Contact entity representing a trusted contact who receives emergency alerts
 */
@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    
    val name: String,
    
    val phoneNumber: String,
    
    val photoUri: String? = null,
    
    // L1 = Family (highest priority), L2 = Friends
    val level: Int = 2,
    
    // true if contact has Aura app and keys are exchanged
    val hasApp: Boolean = false,
    
    // Public encryption key for this contact (Base64 encoded)
    val publicKey: String? = null,
    
    // true if key exchange verified via QR code scan
    val verified: Boolean = false,
    
    val createdAt: Long = System.currentTimeMillis(),
    
    val lastAlertSentAt: Long? = null,
    
    // Total number of alerts sent to this contact
    val alertsSentCount: Int = 0,
    
    // QR code content for key exchange (JSON string)
    val verificationQrCode: String? = null
) {
    val isEncrypted: Boolean
        get() = hasApp && verified && publicKey != null
    
    val statusBadge: String
        get() = if (isEncrypted) "Encrypted" else "SMS Only"
    
    val levelName: String
        get() = when (level) {
            1 -> "Family"
            2 -> "Friends"
            else -> "Unknown"
        }
}
