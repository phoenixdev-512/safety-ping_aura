package com.aura.emergency.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Alert log entity storing details of emergency alerts sent
 */
@Entity(tableName = "alert_logs")
data class AlertLog(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    
    // 1 = High Urgency (Manual/Power button), 2 = Medium (Shake), 3 = Low (Bluetooth)
    val level: Int,
    
    val timestamp: Long = System.currentTimeMillis(),
    
    // GPS coordinates
    val latitude: Double?,
    val longitude: Double?,
    val accuracy: Float?,
    
    // Battery information
    val batteryPercentage: Int?,
    val isCharging: Boolean?,
    
    // Network information
    val networkType: String?, // "WiFi", "4G", "5G", "None"
    
    // Activity recognition
    val activity: String?, // "Walking", "Running", "Still", "Driving", "Unknown"
    val activityConfidence: Int?, // 0-100
    
    // Ambient noise
    val noiseDb: Int?, // Decibels
    
    // Audio snapshot path (encrypted file)
    val audioSnapshotPath: String? = null,
    
    // Alert status
    val isActive: Boolean = true,
    val endedAt: Long? = null,
    
    // Number of contacts alerted
    val contactsAlerted: Int = 0,
    
    // Responses received
    val responsesReceived: Int = 0,
    
    // Trigger method
    val triggerMethod: String // "PowerButton", "Shake", "PanicButton", "VolumeKey", "Bluetooth", "Timer"
) {
    val durationMs: Long?
        get() = if (endedAt != null) endedAt - timestamp else null
    
    val statusText: String
        get() = if (isActive) "Active" else "Ended"
}
