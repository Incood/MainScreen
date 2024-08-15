package com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.sp
import com.example.mainscreen.R
import com.example.mainscreen.data.Tour

@Composable
fun ReviewAndRating(tour: Tour) {
    val sfProMedium = FontFamily(
        Font(R.font.sf_pro_display_medium, FontWeight.Medium)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.padding_extra_medium),
                top = dimensionResource(R.dimen.padding_extra_medium)
            ),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "${tour.countReviews} ${stringResource(id = R.string.reviews)}",
            color = colorResource(id = R.color.white),
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = sfProMedium
            ),
            modifier = Modifier
                .background(
                    colorResource(id = R.color.accent),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_extra_short))
                )
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_small),
                    vertical = dimensionResource(id = R.dimen.padding_short)
                )
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_short)),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(
                    start = dimensionResource(R.dimen.padding_extra_medium)
                )
                .background(
                    Color(0x4DFFFFFF),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_extra_short))
                )
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_small),
                    vertical = dimensionResource(id = R.dimen.padding_short)
                )
        ) {
            repeat(5) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = if (it < (tour.rating
                            ?: 0f).toInt()
                    ) colorResource(id = R.color.star) else colorResource(id = R.color.white),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.padding_extra_medium))
                )
            }
        }
    }
}