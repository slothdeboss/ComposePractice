package com.slothdeboss.composepractice.ui.navigation.routes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.slothdeboss.composepractice.ui.screens.login.LoginScreen
import com.slothdeboss.composepractice.ui.screens.login.LoginViewModel

object LoginNavRoute : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: LoginViewModel = viewModel()

        LoginScreen(
            viewModel = viewModel,
            onSignUpClick = { navigator.push(SignUpRoute) },
            onForgotPasswordClick = {
                val email = viewModel.email
                val screen = if (email.isBlank()) {
                    GetUserEmailRoute
                } else {
                    ConfirmCodeRoute(email = email)
                }
                navigator.push(screen)
            }
        )
    }
}