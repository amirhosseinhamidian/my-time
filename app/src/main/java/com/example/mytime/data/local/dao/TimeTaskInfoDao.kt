package com.example.mytime.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.mytime.data.local.entities.TimeTaskInfoEntity
import com.example.mytime.domain.model.TimeTaskInfo
import java.util.*

@Dao
interface TimeTaskInfoDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(timeTaskInfoEntity: TimeTaskInfoEntity)

    @Query("SELECT * FROM TIME_TASK_INFO WHERE taskId=:taskId ORDER BY date ASC LIMIT 7")
    suspend fun getTimeTaskInfoOneLastWeek(taskId: Int): List<TimeTaskInfoEntity>

    @Query("SELECT * FROM time_task_info WHERE taskId=:taskId AND date=:date")
    suspend fun checkTodayTaskTime(taskId: Int , date: Date):TimeTaskInfoEntity

    @Update
    suspend fun update(timeTaskInfoEntity: TimeTaskInfoEntity)
}