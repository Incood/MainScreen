package com.example.mainscreen.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mainscreen.R
import com.example.mainscreen.data.Screen
import com.example.mainscreen.screens.screensComponents.mainScreenComponents.CityHeader
import com.example.mainscreen.screens.screensComponents.mainScreenComponents.HotelsSection
import com.example.mainscreen.screens.screensComponents.mainScreenComponents.ToursSection
import com.example.mainscreen.viewModel.TourViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: TourViewModel = viewModel()) {
    val tours by viewModel.tours.collectAsState()

    Log.d("MainScreen", "Tours: $tours")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium)
            )
    ) {
        CityHeader(cityName = stringResource(R.string.Makhachkala))
        Divider(
            color = colorResource(id = R.color.almost_white),
            thickness = dimensionResource(id = R.dimen.padding_extra_small),
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        )
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                ToursSection(tours) {
                    navController.navigate(Screen.Tours.route)
                }
                HotelsSection()
            }
        }
    }
}