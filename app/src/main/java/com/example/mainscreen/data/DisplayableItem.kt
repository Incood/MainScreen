package com.example.mainscreen.data

import com.squareup.moshi.Json

interface DisplayableItem {
    val name: String
    val coverImage: String?
    val rating: Double?
    val countReviews: Int?
}