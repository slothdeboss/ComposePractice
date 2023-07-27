package com.slothdeboss.composepractice.ui.components.interests

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.util.VerticalPadding8

@Composable
fun InterestItem(
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    val backgroundColor = if (selected) colors.highlight.lightest else colors.neutralLight.lightest
    val borderColor = if (selected) Color.Transparent else colors.neutralLight.darkest

    Box(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(52.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp),
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.align(Alignment.CenterStart),
            style = typography.bodyM,
            color = colors.neutralDark.darkest
        )

        if (selected) {
            Icon(
                modifier = Modifier.align(Alignment.CenterEnd),
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = null,
                tint = colors.neutralDark.darkest
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterestItemPreview() {
    ComposePracticeTheme {
        Column {
            InterestItem(
                label = "User Experience",
                selected = true
            )

            Spacer(modifier = VerticalPadding8)

            InterestItem(
                label = "User Experience",
                selected = false
            )
        }
    }
}
