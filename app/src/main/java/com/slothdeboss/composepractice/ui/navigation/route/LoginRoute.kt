package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.slothdeboss.composepractice.ui.navigation.direction.ConfirmCodeDirection
import com.slothdeboss.composepractice.ui.navigation.direction.GetUserEmailDirection
import com.slothdeboss.composepractice.ui.navigation.direction.SignUpDirection
import com.slothdeboss.composepractice.ui.screens.login.LoginScreen
import com.slothdeboss.composepractice.ui.screens.login.LoginViewModel

@Composable
fun LoginRoute(navHostController: NavHostController) {

    val viewModel = viewModel { LoginViewModel() }

    LoginScreen(
        viewModel = viewModel,
        onSignUpClick = {
            navHostController.navigate(SignUpDirection.route)
        },
        onForgotPasswordClick = {
            val email = viewModel.email
            if (email.isBlank()) {
                navHostController.navigate(GetUserEmailDirection.route)
            } else {
                navHostController.navigate(ConfirmCodeDirection.provideRouteWithArgs(email))
            }
        }
    )
}