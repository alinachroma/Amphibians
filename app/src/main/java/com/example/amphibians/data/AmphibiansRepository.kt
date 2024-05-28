package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApi
import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibiansData(): List<Amphibian>
}

class NetworkAmphibiansRepository() : AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<Amphibian> {
        return AmphibiansApi.retrofitService.getAmphibiansData()
    }
}