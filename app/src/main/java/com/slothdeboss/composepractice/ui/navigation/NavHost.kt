package com.slothdeboss.composepractice.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.slothdeboss.composepractice.ui.screens.LoginScreen
import com.slothdeboss.composepractice.ui.screens.SignUpScreen

@Composable
fun ComposePracticeNavHost(
    navController: NavHostController,
    startDestination: String = NavDirections.login
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavDirections.login) {
            LoginScreen(
                navigateToRegister = {
                    navController.navigate(NavDirections.signUp)
                }
            )
        }
        composable(NavDirections.signUp) {
            SignUpScreen(
                onLoginClick = {
                    navController.navigate(NavDirections.login)
                }
            )
        }
    }
}