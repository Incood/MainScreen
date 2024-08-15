package com.example.mainscreen.data

data class Hotel(
    override val name: String,
    override val coverImage: String?,
    override val rating: Double?,
    override val countReviews: Int?
) : DisplayableItem