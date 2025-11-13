package com.aura.emergency.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/aura/emergency/data/database/AuraDatabase;", "Landroidx/room/RoomDatabase;", "()V", "alertLogDao", "Lcom/aura/emergency/data/dao/AlertLogDao;", "auditLogDao", "Lcom/aura/emergency/data/dao/AuditLogDao;", "contactDao", "Lcom/aura/emergency/data/dao/ContactDao;", "locationBreadcrumbDao", "Lcom/aura/emergency/data/dao/LocationBreadcrumbDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.aura.emergency.data.model.Contact.class, com.aura.emergency.data.model.AlertLog.class, com.aura.emergency.data.model.LocationBreadcrumb.class, com.aura.emergency.data.model.AuditLog.class}, version = 1, exportSchema = false)
public abstract class AuraDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.aura.emergency.data.database.AuraDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.aura.emergency.data.database.AuraDatabase.Companion Companion = null;
    
    public AuraDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aura.emergency.data.dao.ContactDao contactDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aura.emergency.data.dao.AlertLogDao alertLogDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aura.emergency.data.dao.LocationBreadcrumbDao locationBreadcrumbDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aura.emergency.data.dao.AuditLogDao auditLogDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/aura/emergency/data/database/AuraDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/aura/emergency/data/database/AuraDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "passphrase", "", "closeDatabase", "", "getDatabase", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aura.emergency.data.database.AuraDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String passphrase) {
            return null;
        }
        
        private final com.aura.emergency.data.database.AuraDatabase buildDatabase(android.content.Context context, java.lang.String passphrase) {
            return null;
        }
        
        public final void closeDatabase() {
        }
    }
}