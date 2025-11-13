package com.aura.emergency.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0010H\'J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u0010H\'J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/aura/emergency/data/dao/AlertLogDao;", "", "deleteOldAlerts", "", "beforeTimestamp", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endAlert", "alertId", "", "endedAt", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveAlert", "Lcom/aura/emergency/data/model/AlertLog;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveAlertFlow", "Lkotlinx/coroutines/flow/Flow;", "getAlertLogById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlertLogs", "", "incrementResponses", "insertAlertLog", "alertLog", "(Lcom/aura/emergency/data/model/AlertLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAlertLog", "app_debug"})
@androidx.room.Dao()
public abstract interface AlertLogDao {
    
    @androidx.room.Query(value = "SELECT * FROM alert_logs ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aura.emergency.data.model.AlertLog>> getAllAlertLogs();
    
    @androidx.room.Query(value = "SELECT * FROM alert_logs WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAlertLogById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aura.emergency.data.model.AlertLog> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM alert_logs WHERE isActive = 1 LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActiveAlert(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aura.emergency.data.model.AlertLog> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM alert_logs WHERE isActive = 1 LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.aura.emergency.data.model.AlertLog> getActiveAlertFlow();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAlertLog(@org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.model.AlertLog alertLog, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAlertLog(@org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.model.AlertLog alertLog, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE alert_logs SET isActive = 0, endedAt = :endedAt WHERE id = :alertId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object endAlert(int alertId, long endedAt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE alert_logs SET responsesReceived = responsesReceived + 1 WHERE id = :alertId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object incrementResponses(int alertId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM alert_logs WHERE timestamp < :beforeTimestamp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOldAlerts(long beforeTimestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}