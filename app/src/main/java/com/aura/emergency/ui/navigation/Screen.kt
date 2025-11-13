package com.aura.emergency.ui.navigation

/**
 * Sealed class representing all navigation destinations in the app
 */
sealed class Screen(val route: String) {
    // Onboarding screens
    object Welcome : Screen("welcome")
    object LocalPromise : Screen("local_promise")
    object Permissions : Screen("permissions")
    object AccessibilitySetup : Screen("accessibility_setup")
    object AddFirstContact : Screen("add_first_contact")
    object KeyExchange : Screen("key_exchange/{contactId}") {
        fun createRoute(contactId: Long) = "key_exchange/$contactId"
    }
    object OnboardingComplete : Screen("onboarding_complete")
    
    // Main app screens
    object Dashboard : Screen("dashboard")
    object Contacts : Screen("contacts")
    object ContactDetails : Screen("contact_details/{contactId}") {
        fun createRoute(contactId: Long) = "contact_details/$contactId"
    }
    object AddContact : Screen("add_contact")
    object CheckIn : Screen("checkin")
    object Settings : Screen("settings")
    
    // Alert screens
    object AlertReceived : Screen("alert_received/{alertId}") {
        fun createRoute(alertId: Long) = "alert_received/$alertId"
    }
}
