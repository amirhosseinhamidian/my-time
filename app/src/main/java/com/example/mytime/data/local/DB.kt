package com.example.mytime.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytime.data.local.dao.TaskDao
import com.example.mytime.data.local.dao.TimeTaskInfoDao
import com.example.mytime.data.local.entities.TaskEntity
import com.example.mytime.data.local.entities.TimeTaskInfoEntity

@Database(entities = [TaskEntity::class,TimeTaskInfoEntity::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract val taskDao: TaskDao
    abstract val timeTaskInfoDao: TimeTaskInfoDao
}