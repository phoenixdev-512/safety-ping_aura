package com.aura.emergency.ui.navigation;

/**
 * Sealed class representing all navigation destinations in the app
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000e\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u000e\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"\u00a8\u0006#"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "AccessibilitySetup", "AddContact", "AddFirstContact", "AlertReceived", "CheckIn", "ContactDetails", "Contacts", "Dashboard", "KeyExchange", "LocalPromise", "OnboardingComplete", "Permissions", "Settings", "Welcome", "Lcom/aura/emergency/ui/navigation/Screen$AccessibilitySetup;", "Lcom/aura/emergency/ui/navigation/Screen$AddContact;", "Lcom/aura/emergency/ui/navigation/Screen$AddFirstContact;", "Lcom/aura/emergency/ui/navigation/Screen$AlertReceived;", "Lcom/aura/emergency/ui/navigation/Screen$CheckIn;", "Lcom/aura/emergency/ui/navigation/Screen$ContactDetails;", "Lcom/aura/emergency/ui/navigation/Screen$Contacts;", "Lcom/aura/emergency/ui/navigation/Screen$Dashboard;", "Lcom/aura/emergency/ui/navigation/Screen$KeyExchange;", "Lcom/aura/emergency/ui/navigation/Screen$LocalPromise;", "Lcom/aura/emergency/ui/navigation/Screen$OnboardingComplete;", "Lcom/aura/emergency/ui/navigation/Screen$Permissions;", "Lcom/aura/emergency/ui/navigation/Screen$Settings;", "Lcom/aura/emergency/ui/navigation/Screen$Welcome;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$AccessibilitySetup;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class AccessibilitySetup extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.AccessibilitySetup INSTANCE = null;
        
        private AccessibilitySetup() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$AddContact;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class AddContact extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.AddContact INSTANCE = null;
        
        private AddContact() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$AddFirstContact;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class AddFirstContact extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.AddFirstContact INSTANCE = null;
        
        private AddFirstContact() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$AlertReceived;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "createRoute", "", "alertId", "", "app_debug"})
    public static final class AlertReceived extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.AlertReceived INSTANCE = null;
        
        private AlertReceived() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(long alertId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$CheckIn;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class CheckIn extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.CheckIn INSTANCE = null;
        
        private CheckIn() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$ContactDetails;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "createRoute", "", "contactId", "", "app_debug"})
    public static final class ContactDetails extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.ContactDetails INSTANCE = null;
        
        private ContactDetails() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(long contactId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$Contacts;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Contacts extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.Contacts INSTANCE = null;
        
        private Contacts() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$Dashboard;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Dashboard extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.Dashboard INSTANCE = null;
        
        private Dashboard() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$KeyExchange;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "createRoute", "", "contactId", "", "app_debug"})
    public static final class KeyExchange extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.KeyExchange INSTANCE = null;
        
        private KeyExchange() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(long contactId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$LocalPromise;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class LocalPromise extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.LocalPromise INSTANCE = null;
        
        private LocalPromise() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$OnboardingComplete;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class OnboardingComplete extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.OnboardingComplete INSTANCE = null;
        
        private OnboardingComplete() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$Permissions;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Permissions extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.Permissions INSTANCE = null;
        
        private Permissions() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$Settings;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aura/emergency/ui/navigation/Screen$Welcome;", "Lcom/aura/emergency/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Welcome extends com.aura.emergency.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.aura.emergency.ui.navigation.Screen.Welcome INSTANCE = null;
        
        private Welcome() {
        }
    }
}