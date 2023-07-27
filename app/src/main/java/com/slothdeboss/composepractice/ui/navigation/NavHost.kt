package com.slothdeboss.composepractice.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.slothdeboss.composepractice.ui.navigation.direction.ChooseYourInterestsDirection
import com.slothdeboss.composepractice.ui.navigation.direction.ConfirmCodeDirection
import com.slothdeboss.composepractice.ui.navigation.direction.GetUserEmailDirection
import com.slothdeboss.composepractice.ui.navigation.direction.LoginDirection
import com.slothdeboss.composepractice.ui.navigation.direction.OnboardingDirection
import com.slothdeboss.composepractice.ui.navigation.direction.SignUpDirection
import com.slothdeboss.composepractice.ui.navigation.route.ChooseYourInterestsRoute
import com.slothdeboss.composepractice.ui.navigation.route.ConfirmCodeRoute
import com.slothdeboss.composepractice.ui.navigation.route.GetUserEmailRoute
import com.slothdeboss.composepractice.ui.navigation.route.LoginRoute
import com.slothdeboss.composepractice.ui.navigation.route.OnboardingRoute
import com.slothdeboss.composepractice.ui.navigation.route.SignUpRoute
import com.slothdeboss.composepractice.ui.preferences.OnboardingPreferences
import org.koin.compose.koinInject

@Composable
fun ComposePracticeNavHost(
    navController: NavHostController = rememberNavController()
) {
    val preferences: OnboardingPreferences = koinInject()

    val startDestination = if (preferences.shouldShowOnboarding()) {
        OnboardingDirection.route
    } else {
        LoginDirection.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(OnboardingDirection.route) {
            OnboardingRoute(navController)
        }

        composable(LoginDirection.route) {
            LoginRoute(navController)
        }

        composable(SignUpDirection.route) {
            SignUpRoute(navController)
        }

        composable(
            route = ConfirmCodeDirection.route,
            arguments = listOf(
                navArgument(NavArgument.email) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            ConfirmCodeRoute(entry = entry)
        }

        composable(GetUserEmailDirection.route) {
            GetUserEmailRoute(navController)
        }

        composable(ChooseYourInterestsDirection.route) {
            ChooseYourInterestsRoute(navController)
        }
    }
}
