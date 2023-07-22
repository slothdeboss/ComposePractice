package com.slothdeboss.composepractice.ui.screens.getUserEmail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GetUserEmailViewModel : ViewModel() {

    var email by mutableStateOf("")
        private set

    fun updateEmail(value: String) {
        email = value
    }

    fun isValid() = email.isNotBlank()
}