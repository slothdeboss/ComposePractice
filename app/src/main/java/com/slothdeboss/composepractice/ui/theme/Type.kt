package com.slothdeboss.composepractice.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.slothdeboss.composepractice.R


// Set of Material typography styles to start with
val Typography = ComposeTypography(
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.24.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.09.sp
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.08.sp
    ),
    h4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h5 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    bodyXL = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontSize = 18.sp
    ),
    bodyL = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontSize = 16.sp
    ),
    bodyM = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontSize = 14.sp
    ),
    bodyS = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontSize = 12.sp,
        letterSpacing = 0.12.sp
    ),
    bodyXS = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontSize = 10.sp,
        letterSpacing = 0.15.sp
    ),
    actionL = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight(600),
        fontSize = 14.sp
    ),
    actionM = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight(600),
        fontSize = 12.sp
    ),
    actionS = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight(600),
        fontSize = 10.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter_regular)),
        fontWeight = FontWeight(600),
        fontSize = 10.sp,
        letterSpacing = 0.5.sp
    )
)

@Immutable
data class ComposeTypography(
    val h1: TextStyle = TextStyle.Default,
    val h2: TextStyle = TextStyle.Default,
    val h3: TextStyle = TextStyle.Default,
    val h4: TextStyle = TextStyle.Default,
    val h5: TextStyle = TextStyle.Default,
    val bodyXL: TextStyle = TextStyle.Default,
    val bodyL: TextStyle = TextStyle.Default,
    val bodyM: TextStyle = TextStyle.Default,
    val bodyS: TextStyle = TextStyle.Default,
    val bodyXS: TextStyle = TextStyle.Default,
    val actionL: TextStyle = TextStyle.Default,
    val actionM: TextStyle = TextStyle.Default,
    val actionS: TextStyle = TextStyle.Default,
    val caption: TextStyle = TextStyle.Default
)
