package com.slothdeboss.composepractice.ui.navigation.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingScreen
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingViewModel
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingViewModelFactory

object OnboardingRoute : Screen {

    @Composable
    override fun Content() {
        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow

        val viewModel: OnboardingViewModel = viewModel(
            factory = OnboardingViewModelFactory(context)
        )

        OnboardingScreen(
            viewModel = viewModel,
            navigateNext = { navigator.replace(LoginNavRoute) }
        )
    }
}
