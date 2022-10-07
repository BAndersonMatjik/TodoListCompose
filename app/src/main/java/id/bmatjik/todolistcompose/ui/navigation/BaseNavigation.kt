package id.bmatjik.todolistcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.bmatjik.todolistcompose.HomeScreen
import id.bmatjik.todolistcompose.ui.screen.TodoDetailScreen


@Composable
fun BaseNavigationScreen(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(Screen.Home.route){
            HomeScreen(navController)
        }
        composable(Screen.Home.route){
            TodoDetailScreen(navController)
        }
    }

}

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Detail: Screen("detail")
}