package com.aura.emergency.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Foreground service for sending emergency alerts and location breadcrumbs
 */
class AlertService : Service() {
    
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO: Implement alert service logic
        return START_STICKY
    }
}
