package com.example.jetpackcompose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.Screens.MainScreen
import com.example.jetpackcompose.Screens.Conversation

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.MainScreen.route) {
        composable(AppScreen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            AppScreen.Conversation.route + "/{text}",
            arguments = listOf(navArgument("text") { type = NavType.StringType })
        ) { backStackEntry ->
            val text = backStackEntry.arguments?.getString("text")
            Conversation(navController, text)
        }
    }
}