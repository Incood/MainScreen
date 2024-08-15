package com.example.mainscreen.screens.screensComponents.allToursComponents.TourListDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun TourNameAndDetails(tour: Tour) {
    val sfProRegular = FontFamily(
        Font(R.font.sf_pro_display_regular, FontWeight.Normal)
    )
    val sfProBold = FontFamily(
        Font(R.font.sf_pro_display_bold, FontWeight.Bold)
    )

    Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_extra_medium))) {
        Text(
            text = tour.name,
            fontFamily = sfProBold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_extra_medium)))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = null,
                    tint = colorResource(id = R.color.accent),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.padding_large))
                )
                Text(
                    text = when (tour.duration) {
                        1 -> "${tour.duration} ${stringResource(id = R.string.hour)}"
                        in 2..4 -> "${tour.duration} ${stringResource(id = R.string.hour_s)}"
                        else -> "${tour.duration} ${stringResource(id = R.string.hours)}"
                    },
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = sfProRegular,
                        color = colorResource(id = R.color.light_grey)
                    ),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_extra_short))
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_users),
                    contentDescription = null,
                    tint = colorResource(id = R.color.accent),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.padding_large))
                )
                Text(
                    text = "${tour.groupSize}",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = sfProRegular,
                        color = colorResource(id = R.color.light_grey)
                    ),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_extra_short))
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_extra_short)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_walk),
                    contentDescription = null,
                    tint = colorResource(id = R.color.accent),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.padding_large))
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_bus),
                    contentDescription = null,
                    tint = colorResource(id = R.color.light_grey),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.padding_xmedium))
                )
            }
        }
    }
}