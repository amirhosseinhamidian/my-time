package com.example.mytime.presenter.home

import com.example.mytime.domain.model.Task

data class TaskState(
    val tasks: List<Task> = emptyList(),
    val isLoading: Boolean = false,
)
