package com.slothdeboss.composepractice.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.slothdeboss.composepractice.ui.navigation.route.ConfirmCodeDirection
import com.slothdeboss.composepractice.ui.navigation.route.GetUserEmailDirection
import com.slothdeboss.composepractice.ui.navigation.route.LoginDirection
import com.slothdeboss.composepractice.ui.navigation.route.SignUpDirection
import com.slothdeboss.composepractice.ui.screens.confirmCode.ConfirmCodeScreen
import com.slothdeboss.composepractice.ui.screens.getUserEmail.GetUserEmailScreen
import com.slothdeboss.composepractice.ui.screens.login.LoginScreen
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpScreen

@Composable
fun ComposePracticeNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LoginDirection.route) {
        composable(LoginDirection.route) {
            LoginScreen(
                onSignUpClick = {
                    navController.navigate(SignUpDirection.route)
                }, onForgotPasswordClick = { email ->
                    val route = if (email.isBlank()) {
                        GetUserEmailDirection.route
                    } else {
                        ConfirmCodeDirection.provideRouteWithArgs(email)
                    }
                   navController.navigate(route)
                }
            )
        }

        composable(SignUpDirection.route) {
            SignUpScreen(
                onLoginClick = {
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
            val email = entry.arguments?.getString(NavArgument.email).orEmpty()
            ConfirmCodeScreen(
                email = email
            )
        }

        composable(GetUserEmailDirection.route) {
            GetUserEmailScreen(
                navigateWithEmail = { email ->
                    val route = ConfirmCodeDirection.provideRouteWithArgs(email)
                    navController.navigate(route = route) {
                        popUpTo(GetUserEmailDirection.route) {
                            inclusive = true
                        }
                    }
                }, onBackPressed = {
                   navController.popBackStack()
                }
            )
        }
    }
}