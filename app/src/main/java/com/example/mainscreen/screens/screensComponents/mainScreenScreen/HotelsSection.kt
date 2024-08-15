package com.example.mainscreen.screens.screensComponents.mainScreenScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.mainscreen.R
import com.example.mainscreen.data.Hotel

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
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        LazyRow {
            items(hotels) { hotel ->
                DisplayableItemCard(hotel)
            }
        }
    }
}