package com.arash.applikatask.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _finishTimer = MutableLiveData(false)
    val finishTimer: LiveData<Boolean>
        get() = _finishTimer

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            delay(3000)
            _finishTimer.value = true
        }
    }
}