package com.slothdeboss.composepractice.ui.navigation.routes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import com.slothdeboss.composepractice.ui.screens.confirmCode.ConfirmCodeScreen
import com.slothdeboss.composepractice.ui.screens.confirmCode.ConfirmCodeViewModel

data class ConfirmCodeRoute(
    val email: String
) : Screen {

    @Composable
    override fun Content() {
        val viewModel: ConfirmCodeViewModel = viewModel()

        ConfirmCodeScreen(
            viewModel = viewModel,
            email = email
        )
    }
}
