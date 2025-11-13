package com.aura.emergency

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aura.emergency.ui.dashboard.DashboardScreen
import com.aura.emergency.ui.dashboard.DashboardViewModel
import com.aura.emergency.ui.theme.AuraTheme

class MainActivity : ComponentActivity() {
    
    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        // Handle permission results
        permissions.entries.forEach { entry ->
            val permission = entry.key
            val isGranted = entry.value
            // TODO: Handle permission grant/denial
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Check if first time launch
        val prefs = getSharedPreferences("aura_prefs", MODE_PRIVATE)
        val isFirstLaunch = !prefs.getBoolean("onboarding_completed", false)
        
        if (isFirstLaunch) {
            // TODO: Navigate to onboarding
            // For now, set as completed to show dashboard
            prefs.edit().putBoolean("onboarding_completed", true).apply()
        }
        
        // Request essential permissions
        requestEssentialPermissions()
        
        setContent {
            AuraTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AuraApp()
                }
            }
        }
    }
    
    private fun requestEssentialPermissions() {
        val permissionsToRequest = mutableListOf<String>()
        
        // SMS permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            permissionsToRequest.add(Manifest.permission.SEND_SMS)
        }
        
        // Location permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            permissionsToRequest.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        
        // Notification permission (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                permissionsToRequest.add(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
        
        if (permissionsToRequest.isNotEmpty()) {
            permissionLauncher.launch(permissionsToRequest.toTypedArray())
        }
    }
}

@Composable
fun AuraApp() {
    val application = androidx.compose.ui.platform.LocalContext.current.applicationContext as AuraApplication
    val database = application.database
    
    val dashboardViewModel: DashboardViewModel = viewModel(
        factory = object : androidx.lifecycle.ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return DashboardViewModel(
                    contactDao = database.contactDao(),
                    alertLogDao = database.alertLogDao()
                ) as T
            }
        }
    )
    
    val uiState by dashboardViewModel.uiState.collectAsState()
    
    DashboardScreen(
        uiState = uiState,
        onStartTimer = {
            // TODO: Show timer dialog
        },
        onCancelTimer = {
            dashboardViewModel.cancelSafetyTimer()
        },
        onPanicButtonTriggered = {
            // TODO: Trigger emergency alert
        },
        onNavigateToContacts = {
            // TODO: Navigate to contacts screen
        },
        onNavigateToCheckin = {
            // TODO: Navigate to check-in screen
        },
        onNavigateToSettings = {
            // TODO: Navigate to settings screen
        }
    )
}
