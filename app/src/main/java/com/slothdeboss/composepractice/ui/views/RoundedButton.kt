package com.slothdeboss.composepractice.ui.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    size: Int,
    @DrawableRes
    icon: Int,
    color: Color,
    tintColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    RoundedButton(
        modifier = modifier,
        size = size.dp,
        icon = icon,
        color = color,
        tintColor = tintColor,
        onClick = onClick
    )
}

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    size: Dp,
    @DrawableRes
    icon: Int,
    color: Color,
    tintColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .clickable { onClick() }
            .background(
                color = color,
                shape = RoundedCornerShape(64.dp)
            ),

        ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = tintColor
        )
    }
}