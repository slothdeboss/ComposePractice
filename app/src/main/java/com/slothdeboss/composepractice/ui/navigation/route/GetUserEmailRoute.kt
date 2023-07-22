package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailScreen
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailViewModel

@Composable
fun GetUserEmailRoute(
    navigateToConfirmCode: (email: String) -> Unit = {},
    onBackPressed: () -> Unit = {}
) {

    val viewModel: GetUserEmailViewModel = viewModel()

    GetUserEmailScreen(
        viewModel = viewModel,
        onContinuePressed = {
            val email = viewModel.email
            if (email.isNotBlank()) {
                navigateToConfirmCode(email)
            }
        },
        onBackPressed = onBackPressed
    )
}
