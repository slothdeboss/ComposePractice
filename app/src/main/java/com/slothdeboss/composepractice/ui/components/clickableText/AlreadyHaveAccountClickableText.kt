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

private const val LOGIN_TAG = "__login"

@Composable
fun AlreadyHaveAccountClickableText(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {}
) {
    val annotatedString = provideAlreadyHaveAnAccountMessage()

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = ComposePracticeTheme.typography.actionL,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(tag = LOGIN_TAG, start = offset, end = offset)
                .firstOrNull()?.let { onLoginClick() }
        }
    )
}

@Composable
private fun provideAlreadyHaveAnAccountMessage() : AnnotatedString {

    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    val spanStyleBodyS = typography.bodyS
        .toSpanStyle()
        .copy(color = colors.neutralDark.light)

    val spanStyleActionM = typography.actionM
        .toSpanStyle()
        .copy(color = colors.highlight.darkest)

    val login = stringResource(id = R.string.login)

    return buildAnnotatedString {
        withStyle(style = spanStyleBodyS) {
            append(stringResource(id = R.string.already_have_an_account))
        }
        append(" ")
        withStyle(style = spanStyleActionM) {
            pushStringAnnotation(tag = LOGIN_TAG, annotation = login)
            append(login)
            pop()
        }
    }
}
