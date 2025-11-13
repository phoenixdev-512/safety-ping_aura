package com.aura.emergency.data.dao

import androidx.room.*
import com.aura.emergency.data.model.AlertLog
import kotlinx.coroutines.flow.Flow

@Dao
interface AlertLogDao {
    
    @Query("SELECT * FROM alert_logs ORDER BY timestamp DESC")
    fun getAllAlertLogs(): Flow<List<AlertLog>>
    
    @Query("SELECT * FROM alert_logs WHERE id = :id")
    suspend fun getAlertLogById(id: Int): AlertLog?
    
    @Query("SELECT * FROM alert_logs WHERE isActive = 1 LIMIT 1")
    suspend fun getActiveAlert(): AlertLog?
    
    @Query("SELECT * FROM alert_logs WHERE isActive = 1 LIMIT 1")
    fun getActiveAlertFlow(): Flow<AlertLog?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlertLog(alertLog: AlertLog): Long
    
    @Update
    suspend fun updateAlertLog(alertLog: AlertLog)
    
    @Query("UPDATE alert_logs SET isActive = 0, endedAt = :endedAt WHERE id = :alertId")
    suspend fun endAlert(alertId: Int, endedAt: Long)
    
    @Query("UPDATE alert_logs SET responsesReceived = responsesReceived + 1 WHERE id = :alertId")
    suspend fun incrementResponses(alertId: Int)
    
    @Query("DELETE FROM alert_logs WHERE timestamp < :beforeTimestamp")
    suspend fun deleteOldAlerts(beforeTimestamp: Long)
}
