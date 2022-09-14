package com.example.mytime.presenter.add_time

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytime.domain.model.Icon
import com.example.mytime.domain.model.Task
import com.example.mytime.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTimeViewModel @Inject constructor(
    private val repository: TaskRepository
): ViewModel() {

    private val _title : MutableLiveData<String> = MutableLiveData("")
    val title: LiveData<String> = _title

    private val _icon : MutableLiveData<Icon>  = MutableLiveData(Icon())
    val icon: LiveData<Icon> = _icon

    fun onTitleChange(title: String) {
        _title.value = title
    }

    fun selectIcon(icon: Icon) {
        _icon.value = icon
    }

    fun saveTask() {
        viewModelScope.launch {
            repository.insertTask(Task(title = _title.value!!, iconResId = _icon.value?.id!!))
        }
    }
}