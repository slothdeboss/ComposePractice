package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.slothdeboss.composepractice.ui.navigation.direction.ConfirmCodeDirection
import com.slothdeboss.composepractice.ui.navigation.direction.GetUserEmailDirection
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailScreen
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailViewModel

@Composable
fun GetUserEmailRoute(navHostController: NavHostController) {

    val viewModel: GetUserEmailViewModel = viewModel()

    GetUserEmailScreen(
        viewModel = viewModel,
        onContinuePressed = {
            val email = viewModel.email
            if (email.isNotBlank()) {
                val route = ConfirmCodeDirection.provideRouteWithArgs(email)
                navHostController.navigate(route = route) {
                    popUpTo(GetUserEmailDirection.route) {
                        inclusive = true
                    }
                }
            }
        },
        onBackPressed = {
            navHostController.navigateUp()
        }
    )
}
