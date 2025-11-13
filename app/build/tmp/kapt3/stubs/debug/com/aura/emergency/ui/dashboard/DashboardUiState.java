package com.aura.emergency.ui.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003JQ\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\rH\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/aura/emergency/ui/dashboard/DashboardUiState;", "", "statusText", "", "isAtHome", "", "lastUpdated", "timerActive", "timerRemaining", "", "activeAlert", "Lcom/aura/emergency/data/model/AlertLog;", "contactCount", "", "(Ljava/lang/String;ZLjava/lang/String;ZJLcom/aura/emergency/data/model/AlertLog;I)V", "getActiveAlert", "()Lcom/aura/emergency/data/model/AlertLog;", "getContactCount", "()I", "()Z", "getLastUpdated", "()Ljava/lang/String;", "getStatusText", "getTimerActive", "getTimerRemaining", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class DashboardUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusText = null;
    private final boolean isAtHome = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lastUpdated = null;
    private final boolean timerActive = false;
    private final long timerRemaining = 0L;
    @org.jetbrains.annotations.Nullable()
    private final com.aura.emergency.data.model.AlertLog activeAlert = null;
    private final int contactCount = 0;
    
    public DashboardUiState(@org.jetbrains.annotations.NotNull()
    java.lang.String statusText, boolean isAtHome, @org.jetbrains.annotations.NotNull()
    java.lang.String lastUpdated, boolean timerActive, long timerRemaining, @org.jetbrains.annotations.Nullable()
    com.aura.emergency.data.model.AlertLog activeAlert, int contactCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatusText() {
        return null;
    }
    
    public final boolean isAtHome() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastUpdated() {
        return null;
    }
    
    public final boolean getTimerActive() {
        return false;
    }
    
    public final long getTimerRemaining() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.aura.emergency.data.model.AlertLog getActiveAlert() {
        return null;
    }
    
    public final int getContactCount() {
        return 0;
    }
    
    public DashboardUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.aura.emergency.data.model.AlertLog component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aura.emergency.ui.dashboard.DashboardUiState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String statusText, boolean isAtHome, @org.jetbrains.annotations.NotNull()
    java.lang.String lastUpdated, boolean timerActive, long timerRemaining, @org.jetbrains.annotations.Nullable()
    com.aura.emergency.data.model.AlertLog activeAlert, int contactCount) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}