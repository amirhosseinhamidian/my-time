package com.example.mytime.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mytime.data.local.converter.DateConverter
import com.example.mytime.data.local.dao.TaskDao
import com.example.mytime.data.local.dao.TimeTaskInfoDao
import com.example.mytime.data.local.entities.TaskEntity
import com.example.mytime.data.local.entities.TimeTaskInfoEntity

@Database(entities = [TaskEntity::class,TimeTaskInfoEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class DB : RoomDatabase() {
    abstract val taskDao: TaskDao
    abstract val timeTaskInfoDao: TimeTaskInfoDao
}