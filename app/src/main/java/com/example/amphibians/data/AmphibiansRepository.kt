package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibiansData(): List<Amphibian>
}

class NetworkAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<Amphibian> =
        amphibiansApiService.getAmphibiansData()
}