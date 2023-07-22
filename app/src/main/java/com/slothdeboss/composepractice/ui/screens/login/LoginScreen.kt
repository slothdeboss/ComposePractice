package com.slothdeboss.composepractice.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.components.BoldTitle
import com.slothdeboss.composepractice.ui.components.ContinueWithSocialMedia
import com.slothdeboss.composepractice.ui.components.Logo
import com.slothdeboss.composepractice.ui.components.OutlinedTextWithPlaceholder
import com.slothdeboss.composepractice.ui.components.PasswordOutlinedText
import com.slothdeboss.composepractice.ui.components.RoundedCornerButton
import com.slothdeboss.composepractice.ui.components.clickableText.RegisterNowClickableText
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.util.VerticalPadding12
import com.slothdeboss.composepractice.ui.util.VerticalPadding24
import com.slothdeboss.composepractice.ui.util.VerticalPadding4
import com.slothdeboss.composepractice.ui.util.VerticalPadding8
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onSignUpClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
) {

    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    val keyboardController = LocalSoftwareKeyboardController.current

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        containerColor = colors.neutralLight.lightest
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.highlight.lightest)
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Logo(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(align = Alignment.Bottom)
                    .padding(horizontal = 24.dp, vertical = 40.dp)
            ) {
                BoldTitle(resId = R.string.welcome)

                Spacer(modifier = VerticalPadding12)

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
                    modifier = Modifier.clickable { onForgotPasswordClick() },
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

                RegisterNowClickableText(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onRegisterClick = onSignUpClick
                )

                Divider(
                    modifier = VerticalPadding24,
                    thickness = 1.dp,
                    color = colors.neutralLight.dark
                )

                ContinueWithSocialMedia(
                    modifier = Modifier.fillMaxWidth(),
                    onGoogleClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("On google click!")
                        }
                    },
                    onAppleClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("On apple click!")
                        }
                    },
                    onFacebookClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("On facebook click!")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposePracticeTheme {
        LoginScreen(
            viewModel = viewModel(),
            onSignUpClick = {},
            onForgotPasswordClick = {}
        )
    }
}
