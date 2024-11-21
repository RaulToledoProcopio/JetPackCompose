package com.example.jetpackcompose.Navigation

sealed class AppScreen(val route: String) {
    object MainScreen : AppScreen("MainScreen")
    object Conversation : AppScreen("Conversation/{userName}") {
    }
}
