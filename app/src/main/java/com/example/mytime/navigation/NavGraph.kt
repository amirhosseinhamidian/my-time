package com.example.mytime.navigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mytime.presenter.add_time.AddTimeScreen
import com.example.mytime.presenter.home.HomeScreen


@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable(route = Screen.Home.route){
            HomeScreen(navHostController = navController)
        }
        composable(route = Screen.AddTask.route){
            AddTimeScreen(navHostController = navController)
        }
//        composable(
//            route = Screen.Timer.route,
//            arguments = listOf(navArgument(ID_ARGUMENT){
//                type = NavType.LongType
//            })
//        ){
//            it.arguments?.let { it1 ->
//                TimerScreen(
//                    navHostController = navController,
//                    id = it1.getLong(ID_ARGUMENT)
//                )
//            }
//        }
    }
}