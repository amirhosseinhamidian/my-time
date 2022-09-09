package com.example.mytime.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.mytime.data.local.entities.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(taskEntity: TaskEntity)

    @Delete
    suspend fun delete(taskEntity: TaskEntity)

    @Query("SELECT * FROM task")
    suspend fun getAllTask(): List<TaskEntity>

    @Query("SELECT * FROM task WHERE id=:id")
    suspend fun getTaskById(id:Long): TaskEntity
}