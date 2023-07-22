package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.ui.screens.login.LoginScreen
import com.slothdeboss.composepractice.ui.screens.login.LoginViewModel

@Composable
fun LoginRoute(
    navigateToSignUp: () -> Unit = {},
    navigateToConfirmCode: (email: String) -> Unit = {},
    navigateToGetUserEmail: () -> Unit = {}
) {

    val viewModel = viewModel { LoginViewModel() }

    LoginScreen(
        viewModel = viewModel,
        onSignUpClick = navigateToSignUp,
        onForgotPasswordClick = {
            val email = viewModel.email
            if (email.isBlank()) {
                navigateToGetUserEmail()
            } else {
                navigateToConfirmCode(email)
            }
        }
    )
}