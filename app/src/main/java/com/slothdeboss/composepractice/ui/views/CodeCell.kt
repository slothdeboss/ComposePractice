package com.slothdeboss.composepractice.ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.LocalColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodeCell(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit = {},
    onNextAction: () -> Unit = {},
    size: Dp = 48.dp,
    borderColor: Color = LocalColors.current.neutralDark.lightest,
    cornerSize: Dp = 12.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    TextField(
        modifier = modifier
            .size(size)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(cornerSize)
            ),
        value = value,
        onValueChange = { changedValue ->
            if (changedValue.length <= 1) {
                onValueChange(changedValue)
                if (changedValue.length == 1) {
                    onNextAction()
                }
            }
        },
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            textColor = LocalColors.current.neutralDark.darkest,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
        ),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}

@Preview(showBackground = true)
@Composable
fun CodeCellPreview() {
    ComposePracticeTheme {
        CodeCell(value = "1")
    }
}