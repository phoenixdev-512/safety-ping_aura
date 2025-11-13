package com.aura.emergency.ui.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0013R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/aura/emergency/ui/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "contactDao", "Lcom/aura/emergency/data/dao/ContactDao;", "alertLogDao", "Lcom/aura/emergency/data/dao/AlertLogDao;", "(Lcom/aura/emergency/data/dao/ContactDao;Lcom/aura/emergency/data/dao/AlertLogDao;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/aura/emergency/ui/dashboard/DashboardUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "cancelSafetyTimer", "", "loadDashboardData", "startSafetyTimer", "durationMs", "", "updateGeofenceStatus", "isAtHome", "", "updateTimerRemaining", "remaining", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.aura.emergency.data.dao.ContactDao contactDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aura.emergency.data.dao.AlertLogDao alertLogDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.aura.emergency.ui.dashboard.DashboardUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.aura.emergency.ui.dashboard.DashboardUiState> uiState = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.dao.ContactDao contactDao, @org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.dao.AlertLogDao alertLogDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.aura.emergency.ui.dashboard.DashboardUiState> getUiState() {
        return null;
    }
    
    private final void loadDashboardData() {
    }
    
    public final void updateGeofenceStatus(boolean isAtHome) {
    }
    
    public final void startSafetyTimer(long durationMs) {
    }
    
    public final void cancelSafetyTimer() {
    }
    
    public final void updateTimerRemaining(long remaining) {
    }
}