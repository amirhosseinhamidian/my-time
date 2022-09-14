package com.example.mytime.presenter.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mytime.navigation.Screen

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "MY TIME",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Button(onClick = { navHostController.navigate(Screen.AddTask.route) }) {
            Text(text = "test")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = state.tasks.size ) { i ->
                val task = state.tasks[i]
                TimeItem(
                    task = task,
                    hour = viewModel.getHour(task.id!!),
                    minute = viewModel.getMinute(task.id)
                )
            }
        }
    }
}