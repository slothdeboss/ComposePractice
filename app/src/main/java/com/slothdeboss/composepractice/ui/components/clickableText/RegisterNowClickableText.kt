package com.slothdeboss.composepractice.ui.components.clickableText

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme

private const val REGISTER_NOW_TAG = "__register_now"

@Composable
fun RegisterNowClickableText(
    modifier: Modifier = Modifier,
    onRegisterClick: () -> Unit = {}
) {
    val annotatedString = provideRegisterNowMessage()

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(tag = REGISTER_NOW_TAG, start = offset, end = offset)
                .firstOrNull()?.let { onRegisterClick() }
        }
    )
}

@Composable
private fun provideRegisterNowMessage() : AnnotatedString {
    val typography = ComposePracticeTheme.typography
    val colors = ComposePracticeTheme.colors

    val spanStyleBodyS = typography.bodyS
        .toSpanStyle()
        .copy(color = colors.neutralDark.light)

    val spanStyleActionM = typography.actionM
        .toSpanStyle()
        .copy(color = colors.highlight.darkest)

    val registerNow = stringResource(id = R.string.register_now)

    return buildAnnotatedString {
        withStyle(style = spanStyleBodyS) {
            append(stringResource(id = R.string.not_a_member))
        }

        append(" ")

        withStyle(style = spanStyleActionM) {
            pushStringAnnotation(tag = REGISTER_NOW_TAG, annotation = registerNow)
            append(registerNow)
            pop()
        }
    }
}
