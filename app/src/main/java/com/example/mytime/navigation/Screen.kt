package com.example.mytime.navigation

sealed class Screen(val route: String) {
    object Welcome: Screen(route = "welcome_screen")
    object Home: Screen(route = "home_screen")
    object AddTask: Screen(route = "add_task_screen")
}