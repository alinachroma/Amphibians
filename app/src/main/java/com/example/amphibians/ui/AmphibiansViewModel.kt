package com.example.amphibians.ui

import androidx.lifecycle.ViewModel
import com.example.amphibians.data.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AmphibiansUiState(
    val amphibiansList : List<Amphibian> = emptyList()
)
class AmphibiansViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AmphibiansUiState())
    val uiState: StateFlow<AmphibiansUiState> = _uiState.asStateFlow()
}