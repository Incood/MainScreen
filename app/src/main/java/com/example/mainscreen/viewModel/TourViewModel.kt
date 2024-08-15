package com.example.mainscreen.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainscreen.data.Tour
import com.example.mainscreen.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TourViewModel : ViewModel() {
    private val _tours = MutableStateFlow<List<Tour>>(emptyList())
    val tours: StateFlow<List<Tour>> = _tours.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.tourService.getTours()
                _tours.value = response.results
                Log.d("TourViewModel", "Loaded tours: ${response.results}")
            } catch (e: Exception) {
                Log.e("TourViewModel", "Error loading tours", e)
            }
        }
    }
}