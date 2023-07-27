package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.slothdeboss.composepractice.ui.navigation.direction.ConfirmCodeDirection
import com.slothdeboss.composepractice.ui.navigation.direction.GetUserEmailDirection
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailScreen
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GetUserEmailRoute(navHostController: NavHostController) {

    val viewModel: GetUserEmailViewModel = koinViewModel()

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
