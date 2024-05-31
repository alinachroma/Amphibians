package com.example.amphibians.fake

import com.example.amphibians.data.Amphibian
import com.example.amphibians.data.AmphibiansRepository

class FakeAmphibiansRepository : AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}