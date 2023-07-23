package com.slothdeboss.composepractice.ui.navigation.routes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailScreen
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailViewModel

object GetUserEmailRoute : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: GetUserEmailViewModel = viewModel()

        GetUserEmailScreen(
            viewModel = viewModel,
            onContinuePressed = {
                val email = viewModel.email
                if (email.isNotBlank()) {
                    navigator.push(
                        item = ConfirmCodeRoute(email = email)
                    )
                }
            },
            onBackPressed = { navigator.pop() }
        )
    }
}
