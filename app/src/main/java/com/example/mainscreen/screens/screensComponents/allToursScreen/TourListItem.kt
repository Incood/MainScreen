package com.example.mainscreen.screens.screensComponents.allToursScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails.ImageCard
import com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails.ImagePlaceHolder
import com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails.ReviewAndRating
import com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails.TourNameAndDetails
import com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails.TypeAndPrice
import com.example.mainscreen.R
import com.example.mainscreen.data.Tour

@Composable
fun TourListItem(tour: Tour) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_small)),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.padding_1dp))
    ) {
        Column {
            Box {
                if (tour.coverImage != null) {
                    ImageCard(tour)
                } else {
                    ImagePlaceHolder()
                }
                ReviewAndRating(tour)
                Box(modifier = Modifier.align(Alignment.BottomStart)) {
                    TypeAndPrice(tour)
                }
            }
            TourNameAndDetails(tour)
        }
    }
}