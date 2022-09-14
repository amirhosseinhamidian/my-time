package com.example.mytime.data.repository

import com.example.mytime.data.local.DB
import com.example.mytime.data.mapper.toTask
import com.example.mytime.data.mapper.toTaskEntity
import com.example.mytime.data.mapper.toTaskList
import com.example.mytime.domain.model.Task
import com.example.mytime.domain.repository.TaskRepository
import javax.inject.Inject

class TaskRepositoryImpl @Inject  constructor(
    db: DB
): TaskRepository {
    private val dao = db.taskDao
    override suspend fun insertTask(task: Task) {
        return dao.insert(task.toTaskEntity())
    }

    override suspend fun deleteTask(task: Task) {
        return dao.delete(task.toTaskEntity())
    }

    override suspend fun getAllTsk(): List<Task> {
        return dao.getAllTask().toTaskList()
    }

    override suspend fun getTaskById(id: Long): Task {
        return dao.getTaskById(id).toTask()
    }
}