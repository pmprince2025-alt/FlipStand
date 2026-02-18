package com.princemeher.flipstandclock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.time.format.DateTimeFormatter

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

class ClockViewModelFactory(private val settingsManager: SettingsManager) : ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return ClockViewModel(settingsManager) as T
    }
}

class ClockViewModel(private val settingsManager: SettingsManager) : ViewModel() {

    private val _timeState = MutableStateFlow(LocalTime.now())
    val timeState: StateFlow<LocalTime> = _timeState.asStateFlow()

    val is24HourFormat: StateFlow<Boolean> = settingsManager.is24Hour
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)
    
    val dimMode: StateFlow<Boolean> = settingsManager.dimMode
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    init {
        viewModelScope.launch {
            while (true) {
                _timeState.value = LocalTime.now()
                delay(1000)
            }
        }
    }

    fun toggleTimeFormat() {
        viewModelScope.launch {
            settingsManager.set24HourFormat(!is24HourFormat.value)
        }
    }

    fun toggleDimMode() {
        viewModelScope.launch {
            settingsManager.setDimMode(!dimMode.value)
        }
    }

    fun getTimeFormatted(): String {
        val pattern = if (is24HourFormat.value) "HH:mm" else "hh:mm"
        return _timeState.value.format(DateTimeFormatter.ofPattern(pattern))
    }
}
