package com.slothdeboss.composepractice.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import com.slothdeboss.composepractice.ui.screens.onboarding.entity.OnboardingItem

class OnboardingViewModel : ViewModel() {

    private val items = listOf(
        OnboardingItem(
            title = "Create a components in just a few minutes",
            description = "Enjoy these pre-made compose components and worry only about creating the best product ever."
        ),
        OnboardingItem(
            title = "Abstract your components as much as possible",
            description = "Use base components and shrink the amount of parameters in composable methods."
        ),
        OnboardingItem(
            title = "Say Good Bye to the Android Views",
            description = "Forget about the pain in the ass while developing beautiful design with Jetpack compose."
        ),
    )

    fun getOnboardingItem(page: Int): OnboardingItem {
        return items[page]
    }
}