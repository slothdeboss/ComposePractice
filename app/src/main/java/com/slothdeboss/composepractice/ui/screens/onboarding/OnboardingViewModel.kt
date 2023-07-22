package com.slothdeboss.composepractice.ui.screens.onboarding

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slothdeboss.composepractice.ui.preferences.OnboardingPreferences
import com.slothdeboss.composepractice.ui.screens.onboarding.entity.OnboardingItem

class OnboardingViewModel(
    private val onboardingPreferences: OnboardingPreferences
) : ViewModel() {

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

    fun setOnboardingIsShown() {
        onboardingPreferences.onboardingIsShown()
    }
}

class OnboardingViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnboardingViewModel::class.java)) {
            return OnboardingViewModel(OnboardingPreferences.get(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
