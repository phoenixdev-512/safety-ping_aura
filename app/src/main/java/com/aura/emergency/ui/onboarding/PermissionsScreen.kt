package com.aura.emergency.ui.onboarding

import android.Manifest
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.*

/**
 * Permission Request Screen - Requests SMS and Location permissions
 * 
 * Features:
 * - Two permission cards (SMS, Location)
 * - Clear explanation for each permission
 * - Warning about app functionality
 * - Progress indicator (3/5)
 * - Grant permissions button
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsScreen(
    onBack: () -> Unit,
    onNext: () -> Unit,
    onSkip: () -> Unit
) {
    // Permission states
    val smsPermissionState = rememberPermissionState(
        permission = Manifest.permission.SEND_SMS
    )
    
    val locationPermissionState = rememberPermissionState(
        permission = Manifest.permission.ACCESS_FINE_LOCATION
    )
    
    val notificationPermissionState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        rememberPermissionState(
            permission = Manifest.permission.POST_NOTIFICATIONS
        )
    } else {
        null
    }
    
    // Check if all permissions are granted
    val allPermissionsGranted = smsPermissionState.status.isGranted &&
            locationPermissionState.status.isGranted &&
            (notificationPermissionState?.status?.isGranted ?: true)
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF5E6D3),
                        Color(0xFFFFE5CC)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            
            // Title
            Text(
                text = "We Need Permissions",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // SMS Permission Card
            PermissionCard(
                icon = Icons.Default.Message,
                title = "Send Emergency Alerts",
                description = "To send alerts via SMS without internet",
                isGranted = smsPermissionState.status.isGranted
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Location Permission Card
            PermissionCard(
                icon = Icons.Default.LocationOn,
                title = "Share Your Location",
                description = "To let contacts know where you are ONLY during emergency",
                isGranted = locationPermissionState.status.isGranted
            )
            
            // Notification Permission Card (Android 13+)
            if (notificationPermissionState != null) {
                Spacer(modifier = Modifier.height(16.dp))
                
                PermissionCard(
                    icon = Icons.Default.Notifications,
                    title = "Send Notifications",
                    description = "To receive emergency alerts from your contacts",
                    isGranted = notificationPermissionState.status.isGranted
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Warning box
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFF9800).copy(alpha = 0.1f)
                ),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFF9800), Color(0xFFFF9800))
                    )
                )
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color(0xFFFF9800),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Without these permissions, Aura cannot function",
                        fontSize = 14.sp,
                        color = Color(0xFF212121),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Grant Permissions button
            Button(
                onClick = {
                    if (allPermissionsGranted) {
                        onNext()
                    } else {
                        // Request permissions
                        if (!smsPermissionState.status.isGranted) {
                            smsPermissionState.launchPermissionRequest()
                        } else if (!locationPermissionState.status.isGranted) {
                            locationPermissionState.launchPermissionRequest()
                        } else if (notificationPermissionState != null && 
                                   !notificationPermissionState.status.isGranted) {
                            notificationPermissionState.launchPermissionRequest()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                )
            ) {
                Text(
                    text = if (allPermissionsGranted) "Continue" else "Grant Permissions",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Skip button
            TextButton(
                onClick = onSkip,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Skip (Not Recommended)",
                    fontSize = 14.sp,
                    color = Color(0xFF666666)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Progress indicator
            OnboardingProgressIndicator(
                currentStep = 3,
                totalSteps = 5
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

/**
 * Permission card component
 */
@Composable
private fun PermissionCard(
    icon: ImageVector,
    title: String,
    description: String,
    isGranted: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.9f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = if (isGranted) 
                            Color(0xFF4CAF50).copy(alpha = 0.1f) 
                        else 
                            Color(0xFFBDBDBD).copy(alpha = 0.1f),
                        shape = MaterialTheme.shapes.medium
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isGranted) Color(0xFF4CAF50) else Color(0xFF666666),
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Text content
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontSize = 13.sp,
                    color = Color(0xFF666666),
                    lineHeight = 18.sp
                )
            }
            
            Spacer(modifier = Modifier.width(8.dp))
            
            // Status icon
            Icon(
                imageVector = if (isGranted) Icons.Default.CheckCircle else Icons.Default.Lock,
                contentDescription = null,
                tint = if (isGranted) Color(0xFF4CAF50) else Color(0xFFBDBDBD),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
