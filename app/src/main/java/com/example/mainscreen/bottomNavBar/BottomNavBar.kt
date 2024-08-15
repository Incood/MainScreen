package com.example.mainscreen.bottomNavBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mainscreen.R
import com.example.mainscreen.data.Screen

@Composable
fun BottomNavBar(navController: NavController) {
    val currentRoute = currentRoute(navController)

    Column {
        Divider(
            color = colorResource(id = R.color.almost_white),
            thickness = 1.dp
        )
        BottomAppBar(
            containerColor = Color.White,
            contentColor = colorResource(id = R.color.secondary)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                BottomNavItem(icon = R.drawable.ic_main, label = stringResource(id = R.string.main), route = Screen.Main.route, navController = navController, isSelected = currentRoute == Screen.Main.route)
                BottomNavItem(icon = R.drawable.ic_tours, label = stringResource(id = R.string.tours), route = Screen.Tours.route, navController = navController, isSelected = currentRoute == Screen.Tours.route)
                BottomNavItem(icon = R.drawable.ic_air_tickets, label = stringResource(id = R.string.avia_tickets), route = Screen.AirTickets.route, navController = navController, isSelected = currentRoute == Screen.AirTickets.route)
                BottomNavItem(icon = R.drawable.ic_hotels, label = stringResource(id = R.string.hotels), route = Screen.Hotels.route, navController = navController, isSelected = currentRoute == Screen.Hotels.route)
                BottomNavItem(icon = R.drawable.ic_profile, label = stringResource(id = R.string.profile), route = Screen.Profile.route, navController = navController, isSelected = currentRoute == Screen.Profile.route)
            }
        }
    }
}

@Composable
fun BottomNavItem(icon: Int, label: String, route: String, navController: NavController, isSelected: Boolean = false) {
    val sfProSemibold = FontFamily(
        Font(R.font.sf_pro_display_semibold, FontWeight.Normal)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { navController.navigate(route) }
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = if (isSelected) colorResource(id = R.color.accent) else colorResource(id = R.color.almost_white),
            modifier = Modifier.size(dimensionResource(R.dimen.padding_large))
        )
        Text(
            text = label,
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = sfProSemibold,
                color = if (isSelected) colorResource(id = R.color.accent) else colorResource(id = R.color.almost_white)
            )
        )
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}