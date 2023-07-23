package com.slothdeboss.composepractice.ui.navigation.routes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpScreen
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpViewModel

object SignUpRoute : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: SignUpViewModel = viewModel()

        SignUpScreen(
            viewModel = viewModel,
            onLoginClick = {
                navigator.push(
                    item = LoginNavRoute
                )
            }
        )
    }
}