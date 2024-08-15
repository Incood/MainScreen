package com.example.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mainscreen.bottomNavBar.BottomNavBar
import com.example.mainscreen.data.Screen
import com.example.mainscreen.screens.MainScreen
import com.example.mainscreen.screens.PlaceholderScreen
import com.example.mainscreen.screens.ShowAllToursScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Main.route) { MainScreen(navController) }
            composable(Screen.Tours.route) { ShowAllToursScreen() }
            composable(Screen.AirTickets.route) { PlaceholderScreen(stringResource(R.string.avia_tickets)) }
            composable(Screen.Hotels.route) { PlaceholderScreen(stringResource(R.string.hotels)) }
            composable(Screen.Profile.route) { PlaceholderScreen(stringResource(R.string.profile)) }
        }
    }
}