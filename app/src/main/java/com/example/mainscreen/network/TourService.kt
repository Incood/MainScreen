package com.example.mainscreen.network

import com.example.mainscreen.data.TourResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TourService {
    @GET("tours/")
    suspend fun getTours(): TourResponse
}

object RetrofitClient {
    private const val BASE_URL = "https://api.crontravel.ru/api/v1/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val tourService: TourService = retrofit.create(TourService::class.java)
}