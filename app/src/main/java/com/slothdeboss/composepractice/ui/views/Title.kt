package com.slothdeboss.composepractice.ui.views

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.slothdeboss.composepractice.ui.theme.LocalTypography

@Composable
fun BoldTitle(
    modifier: Modifier = Modifier,
    @StringRes resId: Int
) {
    BoldTitle(modifier = modifier, text = stringResource(resId))
}

@Composable
fun BoldTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = LocalTypography.current.h1
    )
}
