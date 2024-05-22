package com.example.amphibians.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.amphibians.data.Amphibian
sealed class AmphibiansUiState {
    data class Success(val amphibiansList: List<Amphibian>) : AmphibiansUiState()
    object Loading : AmphibiansUiState()
    object Error : AmphibiansUiState()
}

class AmphibiansViewModel : ViewModel() {
    var uiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set
