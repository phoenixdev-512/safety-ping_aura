package com.aura.emergency.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Audit log entity for tracking all app events
 */
@Entity(tableName = "audit_logs")
data class AuditLog(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    
    val timestamp: Long = System.currentTimeMillis(),
    
    val eventType: String, // "AlertSent", "ContactAdded", "SettingChanged", "CheckIn", "KeyExchange"
    
    val eventDescription: String,
    
    val metadata: String? = null // JSON string with additional data
)
