package com.slothdeboss.composepractice.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.util.VerticalPadding8

@Composable
fun ContinueWithSocialMedia(
    modifier: Modifier = Modifier,
    onGoogleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
) {
    val colors = ComposePracticeTheme.colors

    ContinueWithOptions(modifier = modifier) {
        RoundedButton(
            size = 40.dp,
            icon = R.drawable.ic_google,
            color = colors.error.dark,
            onClick = onGoogleClick
        )

        RoundedButton(
            size = 40.dp,
            icon = R.drawable.ic_apple,
            color = colors.neutralDark.darkest,
            onClick = onAppleClick
        )

        RoundedButton(
            size = 40.dp,
            icon = R.drawable.ic_facebook,
            color = colors.highlight.darkest,
            onClick = onFacebookClick
        )
    }
}

@Composable
fun ContinueWithOptions(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit = {}
) {

    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.continue_with),
            style = typography.bodyS,
            color = colors.neutralDark.light
        )

        Spacer(modifier = VerticalPadding8)

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            content = content
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContinueWithOptionsPreview() {
    ComposePracticeTheme {
        ContinueWithSocialMedia()
    }
}
