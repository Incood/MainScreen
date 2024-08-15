package com.example.mainscreen.screens.screensComponents.allToursComponents.FilterButtons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mainscreen.R

@Composable
fun FilterButton(text: String, selectedFilter: String, onClick: () -> Unit) {
    val sfProMedium = FontFamily(
        Font(R.font.sf_pro_display_medium, FontWeight.Medium)
    )
    val isSelected = text == selectedFilter

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) colorResource(id = R.color.accent) else Color.Transparent,
            contentColor = if (isSelected) colorResource(id = R.color.white) else colorResource(id = R.color.gray)
        ),
        shape = RoundedCornerShape(33.dp),
        border = if (!isSelected) BorderStroke(
            dimensionResource(id = R.dimen.padding_extra_small),
            colorResource(id = R.color.dark_blue)
        ) else null,
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.padding_xsmall),
            vertical = dimensionResource(id = R.dimen.padding_extra_small)
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = sfProMedium,
                color = if (isSelected) colorResource(id = R.color.white) else colorResource(id = R.color.dark_blue)
            )
        )
    }
}