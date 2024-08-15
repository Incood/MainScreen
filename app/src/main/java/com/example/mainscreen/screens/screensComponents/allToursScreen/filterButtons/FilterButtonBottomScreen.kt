package com.example.mainscreen.screens.screensComponents.allToursScreen.filterButtons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun FilterButtonBottomScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
        contentAlignment = Alignment.BottomCenter
    ) {
        val sfProSemiBold = FontFamily(
            Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.accent)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_2_1xlarge)),
            contentPadding = PaddingValues(
                horizontal = dimensionResource(id = R.dimen.padding_medium),
                vertical = dimensionResource(id = R.dimen.padding_xshort)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.padding_large))
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_xsmall)))
                Text(
                    text = stringResource(R.string.filter),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = sfProSemiBold,
                        color = colorResource(id = R.color.white)
                    )
                )
            }
        }
    }
}