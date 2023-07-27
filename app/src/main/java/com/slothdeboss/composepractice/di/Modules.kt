package com.slothdeboss.composepractice.di

import com.slothdeboss.composepractice.ui.preferences.OnboardingPreferences
import com.slothdeboss.composepractice.ui.screens.confirmCode.ConfirmCodeViewModel
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailViewModel
import com.slothdeboss.composepractice.ui.screens.interests.ChooseYourInterestsViewModel
import com.slothdeboss.composepractice.ui.screens.login.LoginViewModel
import com.slothdeboss.composepractice.ui.screens.onboarding.OnboardingViewModel
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val preferencesModule = module {
    single { OnboardingPreferences(get()) }
}

val viewModelModule = module {
    viewModel { OnboardingViewModel(get()) }
    viewModel { LoginViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { GetUserEmailViewModel() }
    viewModel { ConfirmCodeViewModel() }
    viewModel { ChooseYourInterestsViewModel() }
}

val appModules = listOf(
    preferencesModule,
    viewModelModule
)
