package com.aura.emergency.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Location breadcrumb entity storing location updates during active alert
 */
@Entity(tableName = "location_breadcrumbs")
data class LocationBreadcrumb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    
    // Reference to parent alert
    val alertLogId: Int,
    
    val timestamp: Long = System.currentTimeMillis(),
    
    val latitude: Double,
    val longitude: Double,
    val accuracy: Float,
    
    // Battery at this breadcrumb
    val batteryPercentage: Int?,
    
    // Activity at this breadcrumb
    val activity: String?,
    
    // Noise level at this breadcrumb
    val noiseDb: Int?
)
