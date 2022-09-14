package com.example.mytime.domain.repository

import com.example.mytime.domain.model.Task

interface TaskRepository {
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun getAllTsk(): List<Task>
    suspend fun getTaskById(id: Long): Task
}