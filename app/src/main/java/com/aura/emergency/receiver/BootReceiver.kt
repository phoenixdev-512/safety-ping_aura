package com.aura.emergency.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Receiver for device boot to restart services
 */
class BootReceiver : BroadcastReceiver() {
    
    override fun onReceive(context: Context?, intent: Intent?) {
        // TODO: Restart services on boot
    }
}
