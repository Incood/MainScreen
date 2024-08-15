package com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.mainscreen.R

@Composable
fun ImagePlaceHolder() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.padding_4xlarge))
            .background(colorResource(id = R.color.gray))
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding_xsmall))),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "No Image", color = colorResource(id = R.color.white))
    }
}