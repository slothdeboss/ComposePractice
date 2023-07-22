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

private const val TERMS_AND_CONDITIONS_TAG = "__terms_and_conditions"
private const val PRIVACY_POLICY_TAG = "__privacy_policy"

@Composable
fun TermsAndConditionsClickableText(
    modifier: Modifier = Modifier,
    onTermsClick: () -> Unit = {},
    onPrivacyPolicyClick: () -> Unit = {}
) {

    val annotatedString = provideTermsAndPrivacyMessage()

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(start = offset, end = offset)
                .firstOrNull()?.let { range ->
                    when(range.tag) {
                        TERMS_AND_CONDITIONS_TAG -> onTermsClick()
                        PRIVACY_POLICY_TAG -> onPrivacyPolicyClick()
                    }
                }
        }
    )
}

@Composable
private fun provideTermsAndPrivacyMessage() : AnnotatedString {
    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    val spanStyleBodyS = typography.bodyS
        .toSpanStyle()
        .copy(color = colors.neutralDark.light)

    val spanStyleActionM = typography.actionM
        .toSpanStyle()
        .copy(color = colors.highlight.darkest)

    val termsAndConditions = stringResource(id = R.string.terms_and_conditions)
    val policies = stringResource(id = R.string.privacy_policy)

    return buildAnnotatedString {
        withStyle(style = spanStyleBodyS) {
            append(stringResource(id = R.string.i_have_read_and_agree_with))
        }

        append(" ")

        withStyle(style = spanStyleActionM) {
            pushStringAnnotation(tag = TERMS_AND_CONDITIONS_TAG, annotation = termsAndConditions)
            append(termsAndConditions)
            pop()
        }

        append(" ")

        withStyle(style = spanStyleBodyS) {
            append(stringResource(id = R.string.and_the))
        }

        append(" ")

        withStyle(style = spanStyleActionM) {
            pushStringAnnotation(tag = PRIVACY_POLICY_TAG, annotation = policies)
            append(policies)
            pop()
        }
    }
}
