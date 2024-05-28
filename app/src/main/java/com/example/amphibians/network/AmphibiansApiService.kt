package com.example.amphibians.network

import com.example.amphibians.data.Amphibian
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibiansData() : List<Amphibian>
}