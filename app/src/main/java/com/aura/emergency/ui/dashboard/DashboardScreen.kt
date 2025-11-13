package com.aura.emergency.ui.dashboard

import android.view.HapticFeedbackConstants
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aura.emergency.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    uiState: DashboardUiState,
    onStartTimer: () -> Unit,
    onCancelTimer: () -> Unit,
    onPanicButtonTriggered: () -> Unit,
    onNavigateToContacts: () -> Unit,
    onNavigateToCheckin: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val view = LocalView.current
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Aura",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Menu */ }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = onNavigateToContacts,
                    icon = { Icon(Icons.Default.People, contentDescription = "Contacts") },
                    label = { Text("Contacts") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = onNavigateToCheckin,
                    icon = { Icon(Icons.Default.CheckCircle, contentDescription = "Check-in") },
                    label = { Text("Check-in") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = onNavigateToSettings,
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            
            // Status Card
            StatusCard(
                statusText = uiState.statusText,
                lastUpdated = uiState.lastUpdated
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Safety Timer Widget
            SafetyTimerWidget(
                isActive = uiState.timerActive,
                remainingMs = uiState.timerRemaining,
                onStart = onStartTimer,
                onCancel = onCancelTimer
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Panic Button
            PanicButton(
                onTriggered = {
                    view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
                    onPanicButtonTriggered()
                }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun StatusCard(
    statusText: String,
    lastUpdated: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = SafeGreen
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(SafeGreen, SafeGreenBorder)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = SuccessGreen,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = statusText,
                        style = MaterialTheme.typography.displayMedium,
                        color = Color(0xFF1B5E20),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Updated: $lastUpdated",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF2E7D32)
                )
            }
        }
    }
}

@Composable
fun SafetyTimerWidget(
    isActive: Boolean,
    remainingMs: Long,
    onStart: () -> Unit,
    onCancel: () -> Unit
) {
    val view = LocalView.current
    
    Card(
        modifier = Modifier.size(150.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = {
            view.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK)
            if (isActive) onCancel() else onStart()
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (isActive) {
                // Show countdown
                val minutes = (remainingMs / 1000 / 60).toInt()
                val seconds = ((remainingMs / 1000) % 60).toInt()
                
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "TIMER ACTIVE",
                        style = MaterialTheme.typography.labelSmall,
                        color = SuccessGreen,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = String.format("%02d:%02d", minutes, seconds),
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (remainingMs < 120000) WarningYellow else SuccessGreen
                    )
                    Text(
                        text = "Remaining",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            } else {
                // Show start button
                Text(
                    text = "START\nSAFETY\nTIMER",
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun PanicButton(
    onTriggered: () -> Unit
) {
    val view = LocalView.current
    var isPressed by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0f) }
    val coroutineScope = rememberCoroutineScope()
    
    val animatedProgress by animateFloatAsState(
        targetValue = if (isPressed) 1f else 0f,
        animationSpec = tween(durationMillis = 3000, easing = LinearEasing),
        label = "panic_progress"
    )
    
    LaunchedEffect(animatedProgress) {
        progress = animatedProgress
        if (animatedProgress >= 0.99f && isPressed) {
            onTriggered()
            isPressed = false
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .height(80.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(AlertRed, Color(0xFFC41C3B))
                )
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
                        
                        // Vibrate during hold
                        val job = coroutineScope.launch {
                            while (isPressed) {
                                delay(500)
                                view.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK)
                            }
                        }
                        
                        tryAwaitRelease()
                        isPressed = false
                        job.cancel()
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        // Progress overlay
        if (progress > 0f) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .fillMaxHeight()
                    .background(Color.White.copy(alpha = 0.3f))
            )
        }
        
        Text(
            text = "HOLD FOR HELP",
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
