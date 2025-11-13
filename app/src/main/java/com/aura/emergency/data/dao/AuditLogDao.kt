package com.aura.emergency.data.dao

import androidx.room.*
import com.aura.emergency.data.model.AuditLog
import kotlinx.coroutines.flow.Flow

@Dao
interface AuditLogDao {
    
    @Query("SELECT * FROM audit_logs ORDER BY timestamp DESC LIMIT 100")
    fun getRecentAuditLogs(): Flow<List<AuditLog>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuditLog(auditLog: AuditLog): Long
    
    @Query("DELETE FROM audit_logs WHERE timestamp < :beforeTimestamp")
    suspend fun deleteOldLogs(beforeTimestamp: Long)
    
    @Query("DELETE FROM audit_logs")
    suspend fun clearAllLogs()
}
