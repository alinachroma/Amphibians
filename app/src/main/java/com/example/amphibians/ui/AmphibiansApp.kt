package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.amphibians.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.data.Amphibian
import com.example.amphibians.ui.AmphibiansUiState.Success
import com.example.amphibians.ui.items.AmphibiansTopBar
import com.example.amphibians.ui.screens.HomeScreen
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibiansApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AmphibiansTopBar(
                topAppBarTitle = stringResource(id = R.string.app_name),
                modifier = Modifier
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val amphibiansViewModel: AmphibiansViewModel =
                viewModel(factory = AmphibiansViewModel.Factory)
            HomeScreen(
                amphibiansUiState = amphibiansViewModel.uiState,
                retryAction = amphibiansViewModel::getAmphibiansData,
                modifier = Modifier,
                contentPadding = it
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibiansAppPreview() {
    AmphibiansTheme {
        val mockData = List(10) {
            Amphibian(
                name = "Amphibian name",
                type = "Type",
                description = "Description",
                imgSrc = "$it"
            )
        }
        HomeScreen(
            amphibiansUiState = Success(
                amphibiansList = mockData
            ),
            retryAction = {}
        )
    }
}
