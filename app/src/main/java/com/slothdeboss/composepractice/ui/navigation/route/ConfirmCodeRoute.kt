package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.slothdeboss.composepractice.ui.navigation.NavArgument
import com.slothdeboss.composepractice.ui.screens.confirmCode.ConfirmCodeScreen
import com.slothdeboss.composepractice.ui.screens.confirmCode.ConfirmCodeViewModel

@Composable
fun ConfirmCodeRoute(
    entry: NavBackStackEntry,
) {
    val email = entry.arguments?.getString(NavArgument.email).orEmpty()

    val viewModel: ConfirmCodeViewModel = viewModel()

    ConfirmCodeScreen(
        viewModel = viewModel,
        email = email
    )
}
