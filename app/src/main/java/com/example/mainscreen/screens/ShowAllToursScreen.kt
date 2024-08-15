package com.example.mainscreen.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mainscreen.screens.screensComponents.allToursScreen.filterButtons.FilterButtonBottomScreen
import com.example.mainscreen.screens.screensComponents.allToursScreen.filterButtons.FilterButtonsRow
import com.example.mainscreen.screens.screensComponents.allToursScreen.TourListItem
import com.example.mainscreen.R
import com.example.mainscreen.screens.screensComponents.mainScreenScreen.CityHeader
import com.example.mainscreen.viewModel.TourViewModel

@Composable
fun ShowAllToursScreen(viewModel: TourViewModel = viewModel()) {
    val tours by viewModel.tours.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
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
            FilterButtonsRow()
            Divider(
                color = colorResource(id = R.color.almost_white),
                thickness = dimensionResource(id = R.dimen.padding_1dp),
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            LazyColumn {
                items(tours) { tour ->
                    TourListItem(tour)
                }
            }
        }
        FilterButtonBottomScreen()
    }
}