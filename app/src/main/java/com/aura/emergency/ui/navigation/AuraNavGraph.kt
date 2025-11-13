package com.aura.emergency.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aura.emergency.ui.dashboard.DashboardScreen
import com.aura.emergency.ui.dashboard.DashboardUiState
import com.aura.emergency.ui.onboarding.*

/**
 * Main navigation graph for the Aura app
 * 
 * Handles navigation between:
 * - Onboarding screens (first time users)
 * - Main app screens (dashboard, contacts, check-in, settings)
 * - Alert screens (receiving/managing alerts)
 */
@Composable
fun AuraNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    dashboardUiState: DashboardUiState,
    onStartTimer: () -> Unit,
    onCancelTimer: () -> Unit,
    onPanicButtonTriggered: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // ===== ONBOARDING SCREENS =====
        
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onGetStarted = {
                    navController.navigate(Screen.LocalPromise.route)
                }
            )
        }
        
        composable(Screen.LocalPromise.route) {
            LocalPromiseScreen(
                onBack = {
                    navController.popBackStack()
                },
                onNext = {
                    navController.navigate(Screen.Permissions.route)
                }
            )
        }
        
        composable(Screen.Permissions.route) {
            PermissionsScreen(
                onBack = {
                    navController.popBackStack()
                },
                onNext = {
                    navController.navigate(Screen.AccessibilitySetup.route)
                },
                onSkip = {
                    // Skip to accessibility setup anyway
                    navController.navigate(Screen.AccessibilitySetup.route)
                }
            )
        }
        
        composable(Screen.AccessibilitySetup.route) {
            AccessibilitySetupScreen(
                onBack = {
                    navController.popBackStack()
                },
                onNext = {
                    navController.navigate(Screen.AddFirstContact.route)
                },
                onSkip = {
                    navController.navigate(Screen.AddFirstContact.route)
                }
            )
        }
        
        composable(Screen.AddFirstContact.route) {
            AddFirstContactScreen(
                onBack = {
                    navController.popBackStack()
                },
                onNext = { contactId ->
                    navController.navigate(Screen.KeyExchange.createRoute(contactId))
                },
                onSkip = {
                    navController.navigate(Screen.OnboardingComplete.route)
                }
            )
        }
        
        composable(Screen.KeyExchange.route) {
            // TODO: Implement KeyExchangeScreen
            // For now, navigate to completion
            navController.navigate(Screen.OnboardingComplete.route)
        }
        
        composable(Screen.OnboardingComplete.route) {
            OnboardingCompleteScreen(
                onContinue = {
                    // Navigate to dashboard and clear backstack
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Welcome.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        
        // ===== MAIN APP SCREENS =====
        
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                uiState = dashboardUiState,
                onStartTimer = onStartTimer,
                onCancelTimer = onCancelTimer,
                onPanicButtonTriggered = onPanicButtonTriggered,
                onNavigateToContacts = {
                    navController.navigate(Screen.Contacts.route)
                },
                onNavigateToCheckin = {
                    navController.navigate(Screen.CheckIn.route)
                },
                onNavigateToSettings = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }
        
        composable(Screen.Contacts.route) {
            // TODO: Implement ContactsScreen
        }
        
        composable(Screen.CheckIn.route) {
            // TODO: Implement CheckInScreen
        }
        
        composable(Screen.Settings.route) {
            // TODO: Implement SettingsScreen
        }
    }
}
