package com.example.mainscreen.screens.screensComponents.mainScreenScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mainscreen.R

@Composable
fun CityHeader(cityName: String) {
    val sfProSemiBold = FontFamily(
        Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.frame_city)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_11dp),
                    top = dimensionResource(id = R.dimen.padding_xsmall),
                    bottom = dimensionResource(id = R.dimen.padding_xsmall)
                )
        ) {
            Text(
                text = stringResource(R.string.where_are_you_going),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = sfProSemiBold,
                    color = colorResource(id = R.color.light_grey)
                )
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_1dp)))
            Text(
                text = cityName,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = sfProSemiBold,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.gray)
                )
            )
        }
    }
}