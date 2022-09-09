package com.example.mytime.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val iconResId: Int,
)
