package com.example.mainscreen.screens.screensComponents.allToursComponents.FilterButtons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mainscreen.R

@Composable
fun FilterButtonsRow() {
    val sfProSemiBold = FontFamily(
        Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
    )
    var selectedFilter by remember { mutableStateOf("Все") }

    Column(
        modifier = Modifier.padding(
            top = dimensionResource(id = R.dimen.padding_medium),
            bottom = dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        Text(
            text = stringResource(R.string.sorted_for),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = sfProSemiBold,
                color = colorResource(id = R.color.dark_blue)
            ),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_extra_medium))
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()

        ) {
            FilterButton(stringResource(R.string.all), selectedFilter) {
                selectedFilter = "Все"
            }
            FilterButton(stringResource(R.string.multi_day_tour), selectedFilter) {
                selectedFilter = "Многодневный тур"
            }
            FilterButton(stringResource(R.string.overview), selectedFilter) {
                selectedFilter = "Обзорная"
            }
            FilterButton(stringResource(R.string.ethno), selectedFilter) {
                selectedFilter = "Этно"
            }
        }
    }
}