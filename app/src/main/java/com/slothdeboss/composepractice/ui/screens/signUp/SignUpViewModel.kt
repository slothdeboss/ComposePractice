package com.slothdeboss.composepractice.ui.screens.signUp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    var name by mutableStateOf("")
        private set

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var confirmPassword by mutableStateOf("")
        private set

    private var isTermsAndPolicyChecked = false

    fun updateTermsAndPolicyState(value: Boolean) {
        isTermsAndPolicyChecked = value
    }

    fun updateName(value: String) {
        name = value
    }

    fun updateEmail(value: String) {
        email = value
    }

    fun updatePassword(value: String) {
        password = value
    }

    fun updateConfirmPassword(value: String) {
        confirmPassword = value
    }

    fun onSignUpClicked() {
        Log.e("TAG", "Sign up data name: $name email: $email password: $password confirm password: $confirmPassword")
    }
}
