package com.aura.emergency.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/aura/emergency/data/dao/LocationBreadcrumbDao;", "", "deleteBreadcrumbsForAlert", "", "alertLogId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBreadcrumbsForAlert", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/aura/emergency/data/model/LocationBreadcrumb;", "getLatestBreadcrumb", "insertBreadcrumb", "", "breadcrumb", "(Lcom/aura/emergency/data/model/LocationBreadcrumb;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface LocationBreadcrumbDao {
    
    @androidx.room.Query(value = "SELECT * FROM location_breadcrumbs WHERE alertLogId = :alertLogId ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aura.emergency.data.model.LocationBreadcrumb>> getBreadcrumbsForAlert(int alertLogId);
    
    @androidx.room.Query(value = "SELECT * FROM location_breadcrumbs WHERE alertLogId = :alertLogId ORDER BY timestamp DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLatestBreadcrumb(int alertLogId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aura.emergency.data.model.LocationBreadcrumb> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBreadcrumb(@org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.model.LocationBreadcrumb breadcrumb, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "DELETE FROM location_breadcrumbs WHERE alertLogId = :alertLogId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBreadcrumbsForAlert(int alertLogId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}