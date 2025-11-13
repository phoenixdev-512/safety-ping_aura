package com.aura.emergency;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/aura/emergency/AuraApplication;", "Landroid/app/Application;", "()V", "<set-?>", "Lcom/aura/emergency/data/database/AuraDatabase;", "database", "getDatabase", "()Lcom/aura/emergency/data/database/AuraDatabase;", "createNotificationChannels", "", "onCreate", "Companion", "app_debug"})
public final class AuraApplication extends android.app.Application {
    private com.aura.emergency.data.database.AuraDatabase database;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ALERT = "alert_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_SERVICE = "service_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_CHECKIN = "checkin_channel";
    @org.jetbrains.annotations.NotNull()
    public static final com.aura.emergency.AuraApplication.Companion Companion = null;
    
    public AuraApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aura.emergency.data.database.AuraDatabase getDatabase() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void createNotificationChannels() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/aura/emergency/AuraApplication$Companion;", "", "()V", "CHANNEL_ALERT", "", "CHANNEL_CHECKIN", "CHANNEL_SERVICE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}