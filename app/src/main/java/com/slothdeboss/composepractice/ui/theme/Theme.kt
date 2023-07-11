package com.slothdeboss.composepractice.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ComposePracticeTheme(content: @Composable () -> Unit) {

    CompositionLocalProvider(
        LocalTypography provides Typography,
        LocalColors provides Colors,
        content = content
    )
}

object ComposePracticeTheme {

    val colors: ComposeColors
        @Composable
        get() = LocalColors.current

    val typography: ComposeTypography
        @Composable
        get() = LocalTypography.current
}