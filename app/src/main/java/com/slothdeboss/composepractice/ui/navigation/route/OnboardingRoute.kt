package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingScreen
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingViewModel
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingViewModelFactory

@Composable
fun OnboardingRoute(
    navigateNext: () -> Unit = {}
) {

    val context = LocalContext.current

    val viewModel: OnboardingViewModel = viewModel(
        factory = OnboardingViewModelFactory(context)
    )

    OnboardingScreen(
        viewModel = viewModel,
        navigateNext = navigateNext
    )
}
