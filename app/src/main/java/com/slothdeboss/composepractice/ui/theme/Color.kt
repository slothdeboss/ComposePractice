package com.slothdeboss.composepractice.ui.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val HighlightLight = Color(0xFFB4DBFF)
val HighlightDarkest = Color(0xFF006FFD)

@Composable
fun highlightButtonColors() = ButtonDefaults.buttonColors(
    containerColor = HighlightDarkest,
    contentColor = Color.White,
    disabledContainerColor = HighlightLight,
    disabledContentColor = Color.Gray
)