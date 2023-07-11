package com.slothdeboss.composepractice.ui.theme

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val HighlightLightest = Color(0xFFEAF2FF)
val HighlightLight = Color(0xFFB4DBFF)
val HighlightMedium = Color(0xFF6FBAFF)
val HighlightDark = Color(0xFF2897FF)
val HighlightDarkest = Color(0xFF006FFD)

val NeutralLightDarkest = Color(0xFFC5C6CC)
val NeutralLightDark = Color(0xFFD4D6DD)
val NeutralLightMedium = Color(0xFFE8E9F1)
val NeutralLight = Color(0xFFF8F9FE)
val NeutralLightLightest = Color(0xFFFFFFFF)

val NeutralDarkDarkest = Color(0xFF1F2024)
val NeutralDark = Color(0xFF2F3036)
val NeutralDarkMedium = Color(0xFF494A50)
val NeutralDarkLight = Color(0xFF71727A)
val NeutralDarkLightest = Color(0xFF8F9098)

val SuccessDark = Color(0xFF298267)
val SuccessMedium = Color(0xFF3AC0A0)
val SuccessLight = Color(0xFFE7F4E8)

val WarningDark = Color(0xFFE86339)
val WarningMedium = Color(0xFFFFB37C)
val WarningLight = Color(0xFFFFF4E4)

val ErrorDark = Color(0xFFED3241)
val ErrorMedium = Color(0xFFFF616D)
val ErrorLight = Color(0xFFFFE2E5)

val Colors = ComposeColors(
    highlight = FullPalette(
        dark = HighlightDark,
        darkest = HighlightDarkest,
        light = HighlightLight,
        lightest = HighlightLightest,
        medium = HighlightMedium
    ),
    neutralDark = FullPalette(
        darkest = NeutralDarkDarkest,
        dark = NeutralDark,
        medium = NeutralDarkMedium,
        light = NeutralDarkLight,
        lightest = NeutralDarkLightest
    ),
    neutralLight = FullPalette(
        darkest = NeutralLightDarkest,
        dark = NeutralLightDark,
        medium = NeutralLightMedium,
        light = NeutralLight,
        lightest = NeutralLightLightest
    ),
    success = DefaultPalette(
        dark = SuccessDark,
        medium = SuccessMedium,
        light = SuccessLight
    ),
    warning = DefaultPalette(
        dark = WarningDark,
        medium = WarningMedium,
        light = WarningLight
    ),
    error = DefaultPalette(
        dark = ErrorDark,
        medium = ErrorMedium,
        light = ErrorLight
    )
)

@Immutable
data class ComposeColors(
    val highlight: FullPalette = FullPalette(),
    val neutralLight: FullPalette = FullPalette(),
    val neutralDark: FullPalette = FullPalette(),
    val success: DefaultPalette = DefaultPalette(),
    val warning: DefaultPalette = DefaultPalette(),
    val error: DefaultPalette = DefaultPalette()
)

data class DefaultPalette(
    val dark: Color = Color.Unspecified,
    val medium: Color = Color.Unspecified,
    val light: Color = Color.Unspecified,
)

data class FullPalette(
    val darkest: Color = Color.Unspecified,
    val dark: Color = Color.Unspecified,
    val medium: Color = Color.Unspecified,
    val light: Color = Color.Unspecified,
    val lightest: Color = Color.Unspecified
)

@Composable
fun highlightButtonColors() = ButtonDefaults.buttonColors(
    containerColor = HighlightDarkest,
    contentColor = Color.White,
    disabledContainerColor = HighlightLight,
    disabledContentColor = Color.Gray
)