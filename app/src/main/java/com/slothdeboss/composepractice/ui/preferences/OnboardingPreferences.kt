package com.slothdeboss.composepractice.ui.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class OnboardingPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    }

    fun shouldShowOnboarding() = !sharedPreferences.getBoolean(IS_SHOWN_KEY, false)

    fun onboardingIsShown() {
        sharedPreferences.edit {
            putBoolean(IS_SHOWN_KEY, true)
        }
    }

    companion object {
        private const val FILE_NAME = "__onboarding"
        private const val IS_SHOWN_KEY = "IS_SHOWN_KEY"
    }
}
