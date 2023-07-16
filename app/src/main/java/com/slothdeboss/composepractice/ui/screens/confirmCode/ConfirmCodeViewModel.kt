package com.slothdeboss.composepractice.ui.screens.confirmCode

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ConfirmCodeViewModel : ViewModel() {

    var confirmCode by mutableStateOf(ConfirmCode())
        private set

    fun updateFirstNumber(number: String) {
        confirmCode = confirmCode.copy(firstNumber = number)
    }

    fun updateSecondNumber(number: String) {
        confirmCode = confirmCode.copy(secondNumber = number)
    }

    fun updateThirdNumber(number: String) {
        confirmCode = confirmCode.copy(thirdNumber = number)
    }

    fun updateFourthNumber(number: String) {
        confirmCode = confirmCode.copy(fourthNumber = number)
    }

    fun validateCode() {
        Log.e("TAG", "Code validation ${confirmCode.isValid()}")
    }
}

data class ConfirmCode(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val thirdNumber: String = "",
    val fourthNumber: String = ""
) {

    fun isValid() = listOf(
        firstNumber,
        secondNumber,
        thirdNumber,
        fourthNumber
    ).all {  it.isNotBlank() }
}