package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.slothdeboss.composepractice.ui.navigation.direction.ChooseYourInterestsDirection
import com.slothdeboss.composepractice.ui.navigation.direction.OnboardingDirection
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingScreen

@Composable
fun OnboardingRoute(navHostController: NavHostController) {

    OnboardingScreen(
        navigateNext = {
            navHostController.navigate(ChooseYourInterestsDirection.route) {
                popUpTo(OnboardingDirection.route) {
                    inclusive = true
                }
            }
        }
    )
}
