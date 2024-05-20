package com.example.amphibians.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AmphibiansUiState(
    val amphibianName: String? = "",
    val amphibianImageId: Int? = null,
    val amphibianDescription: String = ""
)
class AmphibiansViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AmphibiansUiState())
    val uiState: StateFlow<AmphibiansUiState> = _uiState.asStateFlow()
}