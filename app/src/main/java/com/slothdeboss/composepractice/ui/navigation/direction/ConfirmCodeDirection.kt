package com.slothdeboss.composepractice.ui.navigation.direction

import com.slothdeboss.composepractice.ui.navigation.NavArgument

object ConfirmCodeDirection : Direction {
    override val route: String
        get() = "__confirm_code/{${NavArgument.email}}"

    fun provideRouteWithArgs(email: String) = "__confirm_code/$email"
}
