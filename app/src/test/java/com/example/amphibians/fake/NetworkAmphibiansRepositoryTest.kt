package com.example.amphibians.fake

import com.example.amphibians.data.NetworkAmphibiansRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkAmphibiansRepositoryTest {

    @Test
    fun networkAmphibiansRepository_getAmphibiansData_verifyAmphibiansList() =
        runTest {
            val repository = NetworkAmphibiansRepository(
                amphibiansApiService = FakeAmphibiansApiService()
            )
            assertEquals(FakeDataSource.amphibiansList, repository.getAmphibiansData())
        }
}