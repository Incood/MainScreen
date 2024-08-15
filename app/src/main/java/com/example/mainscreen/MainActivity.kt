package com.example.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.mainscreen.bottomNavBar.BottomNavBar
import com.example.mainscreen.data.DisplayableItem
import com.example.mainscreen.data.Hotel
import com.example.mainscreen.data.Screen
import com.example.mainscreen.data.Tour
import com.example.mainscreen.ui.theme.MainScreenTheme
import com.example.mainscreen.viewModel.TourViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Main.route) { MainScreen(navController) }
            composable(Screen.Tours.route) { ShowAllToursScreen() }
            composable(Screen.AirTickets.route) { PlaceholderScreen(stringResource(R.string.avia_tickets)) }
            composable(Screen.Hotels.route) { PlaceholderScreen(stringResource(R.string.hotels)) }
            composable(Screen.Profile.route) { PlaceholderScreen(stringResource(R.string.profile)) }
        }
    }
}

@Composable
fun MainScreen(navController: NavController, viewModel: TourViewModel = viewModel()) {
    val tours by viewModel.tours.collectAsState()

    Log.d("MainScreen", "Tours: $tours")

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
        Divider(
            color = colorResource(id = R.color.almost_white),
            thickness = dimensionResource(id = R.dimen.padding_extra_small),
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        )
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                TourSection(tours) {
                    navController.navigate(Screen.Tours.route)
                }
                HotelsSection()
            }
        }
    }
}

@Composable
fun CityHeader(cityName: String) {
    val sfProSemiBold = FontFamily(
        Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.frame_city)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 11.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )
        ) {
            Text(
                text = stringResource(R.string.where_are_you_going),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = sfProSemiBold,
                    color = colorResource(id = R.color.light_grey)
                )
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_extra_small)))
            Text(
                text = cityName,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = sfProSemiBold,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.gray)
                )
            )
        }
    }
}

@Composable
fun TourSection(tours: List<Tour>, onShowAllClick: () -> Unit) {
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

@Composable
fun HotelsSection(modifier: Modifier = Modifier) {
    val hotels = listOf(
        Hotel("Отель Президент", "https://s3-alpha-sig.figma.com/img/1936/6aca/5a4789ffe4e854be11e285d86440bb4b?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=X6FsW1YYke7j8iVm1N6UHwqLkkRsH4TXbZ6eCMVWOq0hqAptrYz9S6dJQ1jVKTtWNKu7pgpNNzk7APPuHejMGEgSPEIjwwsTOKPxhZnEChuubFy3SlmODUCs98PgoMhtliH~xpsJMWQlrP5vJTDz6fIfD6bVcFcjMzMA2~Ph9TUz8DFkkr1UOvq4~Cha40G8CUSHjYfyVrFWuLcJshATibrVI8R5ek08CdFsrfGSdCdbeNWfTObKomYOP7qwgiK3dx8xUQiWopVGwY81NUNTN5I6LiNNezvb030-9K~6qpDfCZnQkTUBwBljdbeQVkqUhGzVTA1JEHd~b81EnPdUbw__", 5.0, 30),
        Hotel("1000 и 1 ночь", "https://s3-alpha-sig.figma.com/img/e4a2/acc5/bcb2418dba076bb0b4166782de0e7197?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=G~41Jja602BhbIlYVaWRLmj53gK6vLpYC0F1JAwNXeC0z61etUXbIw7~pM2jAZUrzU-SrtOQJWPMcbelhPcIO-O9dAAUI8RHEjNTfASqMsQmMs7bkzSTNck--d5J1EeDGi~rOoh4L7pG4pizYHAMXL-kJDo-4C3kAA2-DNfBv6EHdCzOjQBHaT0vFbqC4tY16itWCSYjVC3XzShMwKjMbW4ze6xqZuTHrFgHUJ9DXoz0JH2mdHCLiUeMxK3Or1w0WbJXxGnEJ4aZnKRCBZkv8JEswpkd4IKE8tjehAPpbw9fq36ENchy0G8u7sXFWjJOuLsB5oAXhWE8Sg~lkDRyQA__", 5.0, 2),
        Hotel("Монто", "https://s3-alpha-sig.figma.com/img/c530/1767/ec32f081d58e74802bf3b28cd23e01e6?Expires=1724630400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=S90QUcc0fTRqDoj3Qb~N4N3rS1np5NCFOcKfK9ukwguIMY4yqfiONzECDT1D2SqTgvH~FMmDrQKkOcnguz~xpx3qX~KT-4eDUZbZK96IHU6I0~3r3V29frEjAsYTaaEWFKN3DU~fMxLH4ENfPbMjsiCP9s3r2lrEQvkVtlTeVQHe8ZIrXD0L2KTDFWsBmmNks~lOAkRssi76rvidb43aKMxaOqyjednCm6WwnWnHHJFGxMNVG9ZgD9tpY9ubn8hcybI7fY76o2TEi4K080ySEZeBp1J3DUH9RnVhJrypr02YB0lkFD~lqGk97G9GlysvLThSA9HvzF63SH0505Z6eA__", 5.0, 2)
    )
    SectionWithShowAll(
        title = stringResource(R.string.find_a_place_to_live),
        onShowAllClick = { },
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(hotels) { hotel ->
                DisplayableItemCard(hotel)
            }
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreenTheme {
        MainApp()
    }
}