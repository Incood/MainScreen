package com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mainscreen.R
import com.example.mainscreen.data.Tour
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TypeAndPrice(tour: Tour) {
    val sfProBold = FontFamily(
        Font(R.font.sf_pro_display_bold, FontWeight.Bold)
    )

    val formattedPrice = tour.adultPrice?.let {
        val numberFormat = NumberFormat.getNumberInstance(Locale("ru", "RU"))
        numberFormat.format(it.toDouble().toInt()) + " ₽"
    } ?: "N/A"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(id = R.dimen.padding_extra_medium),
                end = dimensionResource(id = R.dimen.padding_extra_medium),
                bottom = dimensionResource(id = R.dimen.padding_extra_medium)
            )
    ) {
        Text(
            text = if (tour.type == "group") stringResource(R.string.group_tour) else stringResource(
                R.string.private_tour
            ),
            color = colorResource(id = R.color.white),
            style = TextStyle(
                fontSize = 8.sp,
                fontFamily = sfProBold
            ),
            modifier = Modifier
                .background(
                    Color(0x4DFFFFFF),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_extra_short))
                )
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_short),
                    vertical = dimensionResource(id = R.dimen.padding_short)
                )
                .align(Alignment.Bottom)
        )
        Text(
            text = "от $formattedPrice",
            color = colorResource(id = R.color.dark_blue),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = sfProBold
            ),
            modifier = Modifier
                .background(
                    colorResource(id = R.color.white),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_extra_short))
                )
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_extra_short),
                    vertical = dimensionResource(id = R.dimen.padding_extra_short)
                )
        )
    }
}