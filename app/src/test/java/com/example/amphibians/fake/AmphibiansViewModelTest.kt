package com.example.amphibians.fake

import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.AmphibiansUiState
import com.example.amphibians.ui.AmphibiansViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {


    @Test
    fun amphibiansViewModel_getAmphibiansData_verifyAmphibiansUiStateSuccess() =
        runTest {
            val viewModel = AmphibiansViewModel(
                amphibiansRepository = FakeAmphibiansRepository()
            )
            assertEquals(viewModel.uiState, AmphibiansUiState.Success(
                amphibiansList = FakeDataSource.amphibiansList))
        }
}