package com.example.amphibians.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.Amphibian
import com.example.amphibians.data.NetworkAmphibiansRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibiansUiState {
    data class Success(val amphibiansList: List<Amphibian>) : AmphibiansUiState
    object Loading : AmphibiansUiState
    object Error : AmphibiansUiState
}

class AmphibiansViewModel : ViewModel() {
    var uiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibiansData()
    }

    private fun getAmphibiansData() {
        viewModelScope.launch {
            uiState = try {
                val amphibianRepository = NetworkAmphibiansRepository(retrofitService)
                val result = amphibianRepository.getAmphibiansData()
                AmphibiansUiState.Success(result)
            } catch (e: IOException) {
                AmphibiansUiState.Error
            }
        }
    }
}
