package com.aura.emergency.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Foreground service for tracking location during alerts
 */
class LocationService : Service() {
    
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO: Implement location tracking logic
        return START_STICKY
    }
}
