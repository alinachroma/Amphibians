package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.ui.AmphibiansUiState

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {

    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> {
            LoadingScreen(modifier = Modifier.fillMaxWidth())
        }

        is AmphibiansUiState.Success -> {
            ResultsScreen(
                amphibiansList = amphibiansUiState.amphibiansList,
                contentPadding = contentPadding,
                modifier = modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    ),
            )
        }

        is AmphibiansUiState.Error -> {
            ErrorScreen(
                modifier = Modifier.fillMaxWidth(),
                retryAction = retryAction
            )
        }
    }
}



