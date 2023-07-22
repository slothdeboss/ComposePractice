package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpScreen
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpViewModel

@Composable
fun SignUpRoute(
    navigateToLogin: () -> Unit = {}
) {

    val viewModel: SignUpViewModel = viewModel()

    SignUpScreen(
        viewModel = viewModel,
        onLoginClick = navigateToLogin
    )
}
