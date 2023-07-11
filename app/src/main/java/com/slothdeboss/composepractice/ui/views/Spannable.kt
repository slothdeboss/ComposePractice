package com.slothdeboss.composepractice.ui.views

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.HighlightDarkest
import com.slothdeboss.composepractice.ui.theme.LocalColors

@Composable
fun RegisterNowSpannable(modifier: Modifier = Modifier) {
    val registerNowTag = "__register_now"
    val registerNow = stringResource(id = R.string.register_now)
    val annotatedString = buildAnnotatedString {
        append(stringResource(id = R.string.not_a_member))
        append(" ")
        withStyle(style = SpanStyle(color = HighlightDarkest)) {
            pushStringAnnotation(tag = registerNowTag, annotation = registerNow)
            append(registerNow)
        }
    }

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = ComposePracticeTheme.typography.actionL,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(tag = registerNowTag, start = offset, end = offset)
                .firstOrNull()?.let { Log.e("TAG", it.item) }
        }
    )
}

@Composable
fun TermsAndConditionsSpannable(modifier: Modifier = Modifier) {
    val colors = LocalColors.current

    val termsAndConditionsTag = "__terms_and_conditions"
    val privacyPolicyTag = "__privacy_policy"
    val termsAndConditions = stringResource(id = R.string.terms_and_conditions)
    val policies = stringResource(id = R.string.privacy_policy)
    val annotatedString = buildAnnotatedString {
        append(stringResource(id = R.string.i_have_read_and_agree_with))
        append(" ")
        withStyle(style = SpanStyle(colors.highlight.dark)) {
            pushStringAnnotation(tag = termsAndConditionsTag, annotation = termsAndConditions)
            append(termsAndConditions)
        }
        append(" ")
        append(stringResource(id = R.string.and_the))
        append(" ")
        withStyle(style = SpanStyle(colors.highlight.dark)) {
            pushStringAnnotation(tag = privacyPolicyTag, annotation = policies)
            append(policies)
        }
    }

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = ComposePracticeTheme.typography.actionL,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(tag = termsAndConditionsTag, start = offset, end = offset)
                .firstOrNull()?.let { Log.e("TAG", it.item) }

            annotatedString
                .getStringAnnotations(tag = privacyPolicyTag, start = offset, end = offset)
                .firstOrNull()?.let { Log.e("TAG", it.item) }
        }
    )
}