package com.slothdeboss.composepractice.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.ui.theme.LocalTypography

@Composable
fun RoundedCornerButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    cornerRadius: Dp = 4.dp,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    textColor: Color = Color.Unspecified,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        colors = colors,
        onClick = onClick
    ) {
        Text(
            text = stringResource(id = text),
            color = textColor,
            style = LocalTypography.current.actionM
        )
    }
}
