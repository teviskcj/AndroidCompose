package com.example.navigationanimation.ui.navigation

sealed class Screen(val route: String) {
    object FistScreen : Screen("first_screen")
    object SecondScreen : Screen("second_screen")
}
