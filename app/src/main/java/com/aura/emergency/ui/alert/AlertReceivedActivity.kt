package com.aura.emergency.ui.alert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.aura.emergency.ui.theme.AuraTheme

/**
 * Full-screen activity shown when receiving an emergency alert
 */
class AlertReceivedActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            AuraTheme {
                Text("Alert Received - TODO: Implement full screen alert")
            }
        }
    }
}
