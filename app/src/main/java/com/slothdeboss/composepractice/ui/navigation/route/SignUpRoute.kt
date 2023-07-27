package com.slothdeboss.composepractice.ui.navigation.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.slothdeboss.composepractice.ui.navigation.direction.LoginDirection
import com.slothdeboss.composepractice.ui.screens.signUp.SignUpScreen

@Composable
fun SignUpRoute(navHostController: NavHostController) {

    SignUpScreen(
        onLoginClick = {
            navHostController.navigate(LoginDirection.route)
        }
    )
}
