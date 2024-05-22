package com.example.amphibians.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.Amphibian
import com.example.amphibians.network.AmphibiansApi
import kotlinx.coroutines.launch

sealed class AmphibiansUiState {
    data class Success(val amphibiansList: List<Amphibian>) : AmphibiansUiState()
    object Loading : AmphibiansUiState()
    object Error : AmphibiansUiState()
}

class AmphibiansViewModel : ViewModel() {
    var uiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    private fun getAmphibiansData() {
        viewModelScope.launch {
            val result = AmphibiansApi.retrofitService.getAmphibiansData()
            uiState = AmphibiansUiState.Loading
        }
    }


}
