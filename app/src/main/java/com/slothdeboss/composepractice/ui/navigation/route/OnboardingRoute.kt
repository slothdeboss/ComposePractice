package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingScreen
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingViewModel

@Composable
fun OnboardingRoute(
    navigateNext: () -> Unit = {}
) {

    val viewModel: OnboardingViewModel = viewModel()

    OnboardingScreen(
        viewModel = viewModel,
        navigateNext = navigateNext
    )
}
