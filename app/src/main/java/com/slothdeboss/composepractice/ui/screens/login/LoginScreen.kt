package com.slothdeboss.composepractice.ui.screens.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.HighlightDarkest
import com.slothdeboss.composepractice.ui.theme.LocalColors
import com.slothdeboss.composepractice.ui.theme.LocalTypography
import com.slothdeboss.composepractice.ui.theme.RoundedCornerShape12
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.util.VerticalPadding24
import com.slothdeboss.composepractice.ui.util.VerticalPadding4
import com.slothdeboss.composepractice.ui.util.VerticalPadding8
import com.slothdeboss.composepractice.ui.views.BoldTitle
import com.slothdeboss.composepractice.ui.views.OutlinedTextWithPlaceholder
import com.slothdeboss.composepractice.ui.views.PasswordOutlinedText
import com.slothdeboss.composepractice.ui.views.RegisterNowSpannable
import com.slothdeboss.composepractice.ui.views.RoundedButton
import com.slothdeboss.composepractice.ui.views.RoundedCornerButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit,
    onForgotPasswordClick: (email: String) -> Unit
) {
    val colors = LocalColors.current
    val typography = LocalTypography.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val viewModel = viewModel { LoginViewModel() }

    Surface(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        color = colors.highlight.light
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .align(Alignment.Bottom)
                    .background(colors.neutralLight.lightest)
                    .padding(start = 24.dp, end = 24.dp, top = 40.dp)
            ) {
                BoldTitle(resId = R.string.welcome)

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextWithPlaceholder(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.email,
                    onValueChanged = viewModel::updateEmail,
                    placeholder = R.string.email_address,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = VerticalPadding8)

                PasswordOutlinedText(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.password,
                    onValueChanged = viewModel::updatePassword,
                    placeholder = R.string.password,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )

                Spacer(modifier = VerticalPadding8)

                Text(
                    modifier = Modifier.clickable {
                        onForgotPasswordClick(viewModel.email)
                    },
                    text = stringResource(id = R.string.forgot_password),
                    style = typography.actionM,
                    color = colors.highlight.darkest
                )

                Spacer(modifier = VerticalPadding8)

                RoundedCornerButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = R.string.login,
                    colors = highlightButtonColors(),
                    cornerRadius = 12.dp,
                    textColor = colors.neutralLight.lightest,
                    onClick = viewModel::onLoginClick
                )

                Spacer(modifier = VerticalPadding4)

                RegisterNowSpannable(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onRegisterClick = onSignUpClick
                )

                Divider(
                    modifier = VerticalPadding24,
                    thickness = 1.dp,
                    color = colors.neutralLight.dark
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.continue_with),
                    style = MaterialTheme.typography.labelMedium,
                    color = colors.neutralDark.light
                )

                Spacer(modifier = VerticalPadding8)

                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    RoundedButton(
                        size = 40,
                        icon = R.drawable.ic_google,
                        color = colors.error.dark,
                    ) {

                    }

                    RoundedButton(
                        size = 40.dp,
                        icon = R.drawable.ic_apple,
                        color = colors.neutralDark.darkest,
                    ) {

                    }

                    RoundedButton(
                        size = 40.dp,
                        icon = R.drawable.ic_facebook,
                        color = colors.highlight.darkest,
                    ) {

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposePracticeTheme {
        LoginScreen(onSignUpClick = {}, onForgotPasswordClick = {})
    }
}
