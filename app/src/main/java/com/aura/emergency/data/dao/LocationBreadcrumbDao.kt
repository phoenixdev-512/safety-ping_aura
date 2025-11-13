package com.aura.emergency.data.dao

import androidx.room.*
import com.aura.emergency.data.model.LocationBreadcrumb
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationBreadcrumbDao {
    
    @Query("SELECT * FROM location_breadcrumbs WHERE alertLogId = :alertLogId ORDER BY timestamp DESC")
    fun getBreadcrumbsForAlert(alertLogId: Int): Flow<List<LocationBreadcrumb>>
    
    @Query("SELECT * FROM location_breadcrumbs WHERE alertLogId = :alertLogId ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatestBreadcrumb(alertLogId: Int): LocationBreadcrumb?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreadcrumb(breadcrumb: LocationBreadcrumb): Long
    
    @Query("DELETE FROM location_breadcrumbs WHERE alertLogId = :alertLogId")
    suspend fun deleteBreadcrumbsForAlert(alertLogId: Int)
}
