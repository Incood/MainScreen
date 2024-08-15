package com.example.mainscreen.screens.screensComponents.allToursScreen.tourListDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.mainscreen.R
import com.example.mainscreen.data.Tour
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageCard(tour: Tour) {
    val images = listOf(tour.coverImage) + tour.pictures.take(2).map { it.photo }
    val pagerState = rememberPagerState()

    Column {
        Box {
            HorizontalPager(
                count = images.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.padding_4xlarge))
            ) { page ->
                AsyncImage(
                    model = images[page],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.padding_4xlarge))
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding_xsmall))),
                    error = painterResource(id = R.drawable.ic_placeholder)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_short)),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(
                        top = dimensionResource(R.dimen.padding_extra_la),
                        end = dimensionResource(R.dimen.padding_extra_medium)
                    )
            ) {
                repeat(images.size) { index ->
                    Box(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.padding_extra_short))
                            .background(
                                if (index == pagerState.currentPage) colorResource(
                                    id = R.color.white
                                )
                                else colorResource(id = R.color.gray),
                                shape = RoundedCornerShape(50)
                            )
                    )
                }
            }
        }
    }
}