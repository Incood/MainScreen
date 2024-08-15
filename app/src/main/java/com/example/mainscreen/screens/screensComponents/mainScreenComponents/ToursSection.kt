package com.example.mainscreen.screens.screensComponents.mainScreenComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.mainscreen.R
import com.example.mainscreen.data.Tour

@Composable
fun ToursSection(tours: List<Tour>, onShowAllClick: () -> Unit) {
    SectionWithShowAll(
        title = stringResource(id = R.string.choose_tours),
        onShowAllClick = onShowAllClick
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        var maxHeight by remember { mutableIntStateOf(0) }

        SubcomposeLayout { constraints ->
            val measurables = tours.mapIndexed { index, tour ->
                subcompose("measure_$index") { DisplayableItemCard(tour) }.first().measure(constraints)
            }

            measurables.forEach { placeable ->
                maxHeight = maxOf(maxHeight, placeable.height)
            }

            layout(0, 0) {}
        }

        LazyRow {
            items(tours) { tour ->
                Box(modifier = Modifier.height(with(LocalDensity.current) { maxHeight.toDp() })) {
                    DisplayableItemCard(tour)
                }
            }
        }
    }
}