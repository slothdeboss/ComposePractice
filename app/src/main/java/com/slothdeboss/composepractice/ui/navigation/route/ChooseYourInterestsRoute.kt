package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.slothdeboss.composepractice.ui.navigation.direction.ChooseYourInterestsDirection
import com.slothdeboss.composepractice.ui.navigation.direction.LoginDirection
import com.slothdeboss.composepractice.ui.screens.interests.ChooseYourInterestsScreen
import com.slothdeboss.composepractice.ui.screens.interests.ChooseYourInterestsViewModel

@Composable
fun ChooseYourInterestsRoute(
    navController: NavHostController
) {

    val viewModel: ChooseYourInterestsViewModel = viewModel()

    ChooseYourInterestsScreen(
        onNext = {
            navController.navigate(LoginDirection.route) {
                popUpTo(ChooseYourInterestsDirection.route) {
                    inclusive = true
                }
            }
        }
    )
}
