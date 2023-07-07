package com.slothdeboss.composepractice.ui.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.RoundedCornerShape12

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextWithPlaceholder(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholder: Int,
    shape: Shape = RoundedCornerShape12,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    @DrawableRes
    icon: Int? = null,
    onIconClick: () -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        placeholder = { Text(text = stringResource(placeholder)) },
        shape = shape,
        trailingIcon = {
            if (icon != null) {
                val painter = painterResource(id = icon)
                IconButton(onClick = onIconClick) {
                    Icon(painter = painter, contentDescription = null)
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextWithPlaceholder(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    shape: Shape = RoundedCornerShape12,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    @DrawableRes
    icon: Int? = null,
    onIconClick: () -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
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
        visualTransformation = visualTransformation
    )
}

@Composable
fun PasswordOutlinedText(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes
    placeholder: Int,
    shape: Shape = RoundedCornerShape12,
) {
    PasswordOutlinedText(
        modifier,
        value,
        onValueChange,
        stringResource(id = placeholder),
        shape
    )
}

@Composable
fun PasswordOutlinedText(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    shape: Shape = RoundedCornerShape12,
) {
    var shouldShowPassword by remember { mutableStateOf(false) }
    val icon = if (shouldShowPassword) R.drawable.ic_eye_crossed else R.drawable.ic_eye
    OutlinedTextWithPlaceholder(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        shape = shape,
        icon = icon,
        visualTransformation = PasswordVisualTransformation()
    ) {
        shouldShowPassword = !shouldShowPassword
    }
}
