package com.example.amphibians.fake

import com.example.amphibians.data.Amphibian
import com.example.amphibians.network.AmphibiansApiService

class FakeAmphibiansApiService : AmphibiansApiService {
    override suspend fun getAmphibiansData(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}