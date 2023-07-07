package com.slothdeboss.composepractice.ui.views

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.HighlightDarkest

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
        style = MaterialTheme.typography.labelLarge,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(tag = registerNowTag, start = offset, end = offset)
                .firstOrNull()?.let { Log.e("TAG", it.item) }
        }
    )
}