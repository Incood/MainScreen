package com.example.mainscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mainscreen.data.Tour
import com.example.mainscreen.viewModel.TourViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ShowAllToursScreen(viewModel: TourViewModel = viewModel()) {
    val tours by viewModel.tours.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium)
                )
        ) {
            CityHeader(cityName = stringResource(R.string.Makhachkala))
            FilterSection()
            Divider(
                color = colorResource(id = R.color.almost_white),
                thickness = dimensionResource(id = R.dimen.padding_extra_small),
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            LazyColumn {
                items(tours) { tour ->
                    TourListItem(tour)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
            contentAlignment = Alignment.BottomCenter
        ) {
            FilterButton()
        }
    }
}

@Composable
fun FilterSection() {
    val sfProSemiBold = FontFamily(
        Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
    )
    var selectedFilter by remember { mutableStateOf("Все") }

    Column(
        modifier = Modifier.padding(
            top = dimensionResource(id = R.dimen.padding_medium),
            bottom = dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        Text(
            text = stringResource(R.string.sorted_for),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = sfProSemiBold,
                color = colorResource(id = R.color.dark_blue)
            ),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_extra_medium))
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)

        ) {
            FilterButtonRow(stringResource(R.string.all), selectedFilter) {
                selectedFilter = "Все"
            }
            FilterButtonRow(stringResource(R.string.multi_day_tour), selectedFilter) {
                selectedFilter = "Многодневный тур"
            }
            FilterButtonRow(stringResource(R.string.overview), selectedFilter) {
                selectedFilter = "Обзорная"
            }
            FilterButtonRow(stringResource(R.string.ethno), selectedFilter) {
                selectedFilter = "Этно"
            }
        }
    }
}

@Composable
fun FilterButtonRow(text: String, selectedFilter: String, onClick: () -> Unit) {
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

@Composable
fun FilterButton() {
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

@Composable
fun TourListItem(tour: Tour) {
    val sfProRegular = FontFamily(
        Font(R.font.sf_pro_display_regular, FontWeight.Normal)
    )
    val sfProMedium = FontFamily(
        Font(R.font.sf_pro_display_medium, FontWeight.Medium)
    )
    val sfProBold = FontFamily(
        Font(R.font.sf_pro_display_bold, FontWeight.Bold)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_small)),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.padding_extra_small))
    ) {
        Column {
            Box {
                if (tour.coverImage != null) {
                    AsyncImage(
                        model = tour.coverImage,
                        contentDescription = tour.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(id = R.dimen.padding_4xlarge))
                            .clip(
                                RoundedCornerShape(
                                    topStart = dimensionResource(id = R.dimen.padding_xsmall),
                                    topEnd = dimensionResource(id = R.dimen.padding_xsmall)
                                )
                            )
                    )
                } else {
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
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
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
                Row(
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_short)),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(
                            top = dimensionResource(id = R.dimen.padding_extra_la),
                            end = dimensionResource(id = R.dimen.padding_extra_medium)
                        )
                ) {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.padding_extra_short))
                                .background(
                                    if (it == 0) colorResource(id = R.color.white)
                                    else colorResource(id = R.color.gray),
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }
                val formattedPrice = tour.adultPrice?.let {
                    val numberFormat = NumberFormat.getNumberInstance(Locale("ru", "RU"))
                    numberFormat.format(it.toDouble().toInt()) + " ₽"
                } ?: "N/A"
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = dimensionResource(id = R.dimen.padding_extra_medium),
                            end = dimensionResource(id = R.dimen.padding_extra_medium),
                            bottom = dimensionResource(id = R.dimen.padding_extra_medium)
                        )
                        .align(Alignment.BottomStart)
                ) {
                    Text(
                        text = if (tour.type == "group") stringResource(R.string.group_tour) else stringResource(
                            R.string.private_tour
                        ),
                        color = colorResource(id = R.color.white),
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = sfProBold
                        ),
                        modifier = Modifier
                            .background(
                                Color(0x4DFFFFFF),
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_extra_short))
                            )
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_short),
                                vertical = dimensionResource(id = R.dimen.padding_short)
                            )
                            .align(Alignment.Bottom)
                    )
                    Text(
                        text = "от $formattedPrice",
                        color = colorResource(id = R.color.dark_blue),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = sfProBold
                        ),
                        modifier = Modifier
                            .background(
                                colorResource(id = R.color.white),
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_extra_short))
                            )
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_extra_short),
                                vertical = dimensionResource(id = R.dimen.padding_extra_short)
                            )
                    )
                }
            }
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
                                .padding(start = dimensionResource(id = R.dimen.padding_extra_short))
                        )
                    }
                }
            }
        }
    }
}