package com.aura.emergency

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.aura.emergency.data.database.AuraDatabase
import com.aura.emergency.util.EncryptionUtil

class AuraApplication : Application() {
    
    lateinit var database: AuraDatabase
        private set
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize encrypted database
        val passphrase = EncryptionUtil.generateDatabasePassphrase(this)
        database = AuraDatabase.getDatabase(this, passphrase)
        
        // Create notification channels
        createNotificationChannels()
    }
    
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NotificationManager::class.java)
            
            // Alert channel (high priority)
            val alertChannel = NotificationChannel(
                CHANNEL_ALERT,
                "Emergency Alerts",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Critical emergency alert notifications"
                enableVibration(true)
                enableLights(true)
                setShowBadge(true)
            }
            
            // Service channel (default priority)
            val serviceChannel = NotificationChannel(
                CHANNEL_SERVICE,
                "Background Services",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Ongoing alert tracking and location services"
                enableVibration(false)
                setShowBadge(false)
            }
            
            // Check-in channel (low priority)
            val checkinChannel = NotificationChannel(
                CHANNEL_CHECKIN,
                "Check-in Reminders",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Scheduled check-in reminders"
                enableVibration(true)
                setShowBadge(true)
            }
            
            notificationManager.createNotificationChannels(
                listOf(alertChannel, serviceChannel, checkinChannel)
            )
        }
    }
    
    companion object {
        const val CHANNEL_ALERT = "alert_channel"
        const val CHANNEL_SERVICE = "service_channel"
        const val CHANNEL_CHECKIN = "checkin_channel"
    }
}
