package com.slothdeboss.composepractice.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.slothdeboss.composepractice.ui.navigation.direction.ConfirmCodeDirection
import com.slothdeboss.composepractice.ui.navigation.direction.GetUserEmailDirection
import com.slothdeboss.composepractice.ui.navigation.direction.LoginDirection
import com.slothdeboss.composepractice.ui.navigation.direction.OnboardingDirection
import com.slothdeboss.composepractice.ui.navigation.direction.SignUpDirection
import com.slothdeboss.composepractice.ui.navigation.route.ConfirmCodeRoute
import com.slothdeboss.composepractice.ui.navigation.route.GetUserEmailRoute
import com.slothdeboss.composepractice.ui.navigation.route.LoginRoute
import com.slothdeboss.composepractice.ui.navigation.route.OnboardingRoute
import com.slothdeboss.composepractice.ui.navigation.route.SignUpRoute
import com.slothdeboss.composepractice.ui.preferences.OnboardingPreferences

@Composable
fun ComposePracticeNavHost(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current.applicationContext
    val preferences = OnboardingPreferences.get(context)
    val startDestination = if (preferences.shouldShowOnboarding()) {
        OnboardingDirection.route
    } else {
        LoginDirection.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(OnboardingDirection.route) {
            OnboardingRoute(
                navigateNext = {
                    navController.navigate(LoginDirection.route) {
                        popUpTo(OnboardingDirection.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(LoginDirection.route) {
            LoginRoute(
                navigateToSignUp = {
                    navController.navigate(SignUpDirection.route)
                },
                navigateToConfirmCode = { email ->
                    navController.navigate(ConfirmCodeDirection.provideRouteWithArgs(email))
                },
                navigateToGetUserEmail = {
                    navController.navigate(GetUserEmailDirection.route)
                }
            )
        }

        composable(SignUpDirection.route) {
            SignUpRoute(
                navigateToLogin = {
                    navController.navigate(LoginDirection.route)
                }
            )
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
            GetUserEmailRoute(
                navigateToConfirmCode = { email ->
                    val route = ConfirmCodeDirection.provideRouteWithArgs(email)
                    navController.navigate(route = route) {
                        popUpTo(GetUserEmailDirection.route) {
                            inclusive = true
                        }
                    }
                }, onBackPressed = {
                    navController.navigateUp()
                }
            )
        }
    }
}