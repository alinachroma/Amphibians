package com.example.amphibians.network

import com.example.amphibians.data.Amphibian
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibiansData() : List<Amphibian>
}

object AmphibiansApi {
    val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }
}