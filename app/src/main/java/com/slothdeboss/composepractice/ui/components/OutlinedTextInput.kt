package com.slothdeboss.composepractice.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.RoundedCornerShape12

@Composable
fun OutlinedTextWithPlaceholder(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    @StringRes placeholder: Int,
    shape: Shape = RoundedCornerShape12,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    @DrawableRes
    icon: Int? = null,
    onIconClick: () -> Unit = {},
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false
) {

    OutlinedTextWithPlaceholder(
        modifier = modifier,
        value = value,
        onValueChanged = onValueChanged,
        placeholder = stringResource(id = placeholder),
        shape = shape,
        visualTransformation = visualTransformation,
        icon = icon,
        onIconClick = onIconClick,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextWithPlaceholder(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    placeholder: String,
    shape: Shape = RoundedCornerShape12,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    @DrawableRes
    icon: Int? = null,
    onIconClick: () -> Unit = {},
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { newValue ->
            onValueChanged(newValue)
        },
        placeholder = { Text(text = placeholder) },
        shape = shape,
        trailingIcon = {
            if (icon != null) {
                val painter = painterResource(id = icon)
                IconButton(onClick = onIconClick) {
                    Icon(painter = painter, contentDescription = null)
                }
            }
        },
        visualTransformation = visualTransformation,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine
    )
}

@Composable
fun PasswordOutlinedText(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    @StringRes
    placeholder: Int,
    shape: Shape = RoundedCornerShape12,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    PasswordOutlinedText(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        placeholder = stringResource(id = placeholder),
        shape = shape,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun PasswordOutlinedText(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    shape: Shape = RoundedCornerShape12,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    var shouldShowPassword by remember { mutableStateOf(false) }
    val icon = if (shouldShowPassword) R.drawable.ic_eye_crossed else R.drawable.ic_eye
    val transformation = if (shouldShowPassword) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextWithPlaceholder(
        modifier = modifier,
        value = value,
        onValueChanged = onValueChange,
        placeholder = placeholder,
        shape = shape,
        icon = icon,
        visualTransformation = transformation,
        onIconClick = { shouldShowPassword = !shouldShowPassword },
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        singleLine = true
    )
}
