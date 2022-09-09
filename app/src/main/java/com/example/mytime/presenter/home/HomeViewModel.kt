package com.example.mytime.presenter.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel() {

    var state by mutableStateOf(TaskState())


    fun getHour(id: Long): Int {
        TODO("Not yet implemented")
    }

    fun getMinute(id: Long): Int {
        TODO("Not yet implemented")
    }
}