package com.slothdeboss.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.navigator.Navigator
import com.slothdeboss.composepractice.ui.navigation.routes.LoginNavRoute
import com.slothdeboss.composepractice.ui.navigation.routes.OnboardingRoute
import com.slothdeboss.composepractice.ui.preferences.OnboardingPreferences
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                val context = LocalContext.current.applicationContext

                val onboardingPreferences = OnboardingPreferences.get(context)

                val screen = if (onboardingPreferences.shouldShowOnboarding()) {
                    OnboardingRoute
                } else {
                    LoginNavRoute
                }

                Navigator(screen = screen)
            }
        }
    }
}
