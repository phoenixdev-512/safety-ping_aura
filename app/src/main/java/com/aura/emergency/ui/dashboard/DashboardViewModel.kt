package com.aura.emergency.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aura.emergency.data.dao.AlertLogDao
import com.aura.emergency.data.dao.ContactDao
import com.aura.emergency.data.model.AlertLog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DashboardUiState(
    val statusText: String = "Status: SAFE",
    val isAtHome: Boolean = false,
    val lastUpdated: String = "Just now",
    val timerActive: Boolean = false,
    val timerRemaining: Long = 0L, // milliseconds
    val activeAlert: AlertLog? = null,
    val contactCount: Int = 0
)

class DashboardViewModel(
    private val contactDao: ContactDao,
    private val alertLogDao: AlertLogDao
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()
    
    init {
        loadDashboardData()
    }
    
    private fun loadDashboardData() {
        viewModelScope.launch {
            // Load contact count
            val count = contactDao.getContactCount()
            _uiState.value = _uiState.value.copy(contactCount = count)
            
            // Monitor active alerts
            alertLogDao.getActiveAlertFlow().collect { alert ->
                _uiState.value = _uiState.value.copy(activeAlert = alert)
            }
        }
    }
    
    fun updateGeofenceStatus(isAtHome: Boolean) {
        _uiState.value = _uiState.value.copy(
            isAtHome = isAtHome,
            statusText = if (isAtHome) "Status: SAFE at Home" else "Status: SAFE"
        )
    }
    
    fun startSafetyTimer(durationMs: Long) {
        _uiState.value = _uiState.value.copy(
            timerActive = true,
            timerRemaining = durationMs
        )
    }
    
    fun cancelSafetyTimer() {
        _uiState.value = _uiState.value.copy(
            timerActive = false,
            timerRemaining = 0L
        )
    }
    
    fun updateTimerRemaining(remaining: Long) {
        _uiState.value = _uiState.value.copy(timerRemaining = remaining)
    }
}
