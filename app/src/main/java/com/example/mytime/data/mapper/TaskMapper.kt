package com.example.mytime.data.mapper

import com.example.mytime.data.local.entities.TaskEntity
import com.example.mytime.domain.model.Task

fun TaskEntity.toTask(): Task {
    return Task(
        id = id,
        title = title,
        iconResId = iconResId
    )
}

fun Task.toTaskEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        iconResId = iconResId
    )
}

fun List<TaskEntity>.toTaskList() : List<Task> {
    return map {
        it.toTask()
    }
}

fun List<Task>.toTaskEntityList() : List<TaskEntity> {
    return map {
        it.toTaskEntity()
    }
}