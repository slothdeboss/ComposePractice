package com.slothdeboss.composepractice.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.slothdeboss.composepractice.ui.navigation.direction.ConfirmCodeDirection
import com.slothdeboss.composepractice.ui.navigation.direction.GetUserEmailDirection
import com.slothdeboss.composepractice.ui.navigation.direction.LoginDirection
import com.slothdeboss.composepractice.ui.navigation.direction.SignUpDirection
import com.slothdeboss.composepractice.ui.navigation.route.ConfirmCodeRoute
import com.slothdeboss.composepractice.ui.navigation.route.GetUserEmailRoute
import com.slothdeboss.composepractice.ui.navigation.route.LoginRoute
import com.slothdeboss.composepractice.ui.navigation.route.SignUpRoute

@Composable
fun ComposePracticeNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = LoginDirection.route) {
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