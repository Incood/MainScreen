package com.example.mainscreen.screens.screensComponents.mainScreenScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

@Composable
fun SectionWithShowAll(
    title: String,
    onShowAllClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val sfProMedium = FontFamily(
        Font(R.font.sf_pro_display_medium, FontWeight.Medium)
    )

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = sfProMedium,
                    color = colorResource(id = R.color.black)
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(onClick = onShowAllClick)
            ) {
                Text(
                    text = stringResource(id = R.string.show_all),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = sfProMedium,
                        color = colorResource(id = R.color.secondary)
                    )
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_short)))
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_left),
                    contentDescription = null,
                    tint = colorResource(id = R.color.secondary),
                    modifier = Modifier.size(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
        content()
    }
}