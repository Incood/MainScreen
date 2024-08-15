package com.example.mainscreen.data

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Tours : Screen("tours")
    object AirTickets : Screen("airTickets")
    object Hotels : Screen("hotels")
    object Profile : Screen("profile")
}