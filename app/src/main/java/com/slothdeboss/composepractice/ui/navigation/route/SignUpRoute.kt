package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.slothdeboss.composepractice.ui.navigation.direction.LoginDirection
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpScreen
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpViewModel

@Composable
fun SignUpRoute(navHostController: NavHostController) {

    val viewModel: SignUpViewModel = viewModel()

    SignUpScreen(
        viewModel = viewModel,
        onLoginClick = {
            navHostController.navigate(LoginDirection.route)
        }
    )
}
