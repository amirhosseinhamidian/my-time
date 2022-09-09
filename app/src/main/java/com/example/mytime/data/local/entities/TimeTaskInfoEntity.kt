package com.example.mytime.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "time_task_info")
data class TimeTaskInfoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val time: Double,
    val date: Date,
    val taskId: Long
)
