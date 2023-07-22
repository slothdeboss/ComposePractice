package com.slothdeboss.composepractice.ui.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun DotTabRow(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    val colors = ComposePracticeTheme.colors

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(pageCount) { iteration ->
            val color = if (currentPage == iteration) {
                colors.highlight.darkest
            } else {
                colors.neutralLight.darkest
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }
    }
}