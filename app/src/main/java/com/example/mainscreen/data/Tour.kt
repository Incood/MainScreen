package com.example.mainscreen.data

import com.squareup.moshi.Json

data class Tour(
    val id: Int,
    override val name: String,
    val type: String,
    val duration: Int,
    @Json(name = "adult_price") val adultPrice: String?,
    @Json(name = "group_size") val groupSize: Int,
    @Json(name = "age_limit") val ageLimit: Int,
    @Json(name = "cover_image") override val coverImage: String?,
    @Json(name = "children_ticket") val childrenTicket: ChildrenTicket?,
    val nameplate: String?,
    @Json(name = "finish_price") val finishPrice: String?,
    val status: String,
    val pictures: List<Picture>,
    override val rating: Double?,
    @Json(name = "count_reviews") override val countReviews: Int?
) : DisplayableItem

data class ChildrenTicket(
    val price: Float,
    @Json(name = "age_limit") val ageLimit: Int
)

data class Picture(
    val id: Int,
    val photo: String,
    val order: Int
)

data class TourResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Tour>
)