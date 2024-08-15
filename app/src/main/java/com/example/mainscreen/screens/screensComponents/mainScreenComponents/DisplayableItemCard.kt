package com.example.mainscreen.screens.screensComponents.mainScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mainscreen.R
import com.example.mainscreen.data.DisplayableItem

@Composable
fun DisplayableItemCard(item: DisplayableItem) {
    val sfProMedium = FontFamily(
        Font(R.font.sf_pro_display_medium, FontWeight.Medium)
    )
    Column(
        modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.padding_small),
                bottom = dimensionResource(R.dimen.padding_small),
                end = dimensionResource(R.dimen.padding_medium)
            )
            .width(158.dp)
    ) {
        if (item.coverImage != null) {
            var isLoading by remember { mutableStateOf(true) }
            Box {
                AsyncImage(
                    model = item.coverImage,
                    contentDescription = item.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(156.dp)
                        .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
                    onSuccess = { isLoading = false },
                    onError = { isLoading = false }
                )
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .width(158.dp)
                    .height(156.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.gray))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No Image", color = Color.White)
            }
        }
        Column(
            modifier = Modifier
                .padding(
                    top = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_small)
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = colorResource(id = R.color.secondary),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.padding_xsmall))
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_short)))
                Text(
                    text = "${
                        String.format(
                            "%.1f",
                            item.rating ?: 0.0
                        )
                    } (${item.countReviews ?: "N/A"})",
                    color = colorResource(id = R.color.dark_blue),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = sfProMedium
                    )
                )
            }
            Text(
                text = item.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = sfProMedium,
                    color = colorResource(id = R.color.dark_blue)
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_short))
            )
        }
    }
}