package com.slothdeboss.composepractice.ui.screens.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.components.OutlinedTextWithPlaceholder
import com.slothdeboss.composepractice.ui.components.PasswordOutlinedText
import com.slothdeboss.composepractice.ui.components.RoundedCornerButton
import com.slothdeboss.composepractice.ui.components.RoundedCornerCheckBox
import com.slothdeboss.composepractice.ui.components.clickableText.AlreadyHaveAccountClickableText
import com.slothdeboss.composepractice.ui.components.clickableText.TermsAndConditionsClickableText
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.util.HorizontalPadding8
import com.slothdeboss.composepractice.ui.util.VerticalPadding16
import com.slothdeboss.composepractice.ui.util.VerticalPadding24
import com.slothdeboss.composepractice.ui.util.VerticalPadding8

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    onLoginClick: () -> Unit = {}
) {

    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    val keyboardController = LocalSoftwareKeyboardController.current

    val snackBarState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackBarState)
        },
        containerColor = colors.neutralLight.lightest
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.sign_up),
                style = typography.h3,
                color = colors.neutralDark.darkest
            )

            Spacer(modifier = VerticalPadding8)

            Text(
                text = stringResource(id = R.string.create_account_to_start),
                style = typography.bodyS,
                color = colors.neutralDark.light
            )

            Spacer(modifier = VerticalPadding24)

            Text(
                text = stringResource(id = R.string.name),
                style = typography.h5,
                color = colors.neutralDark.dark
            )

            Spacer(modifier = VerticalPadding8)

            OutlinedTextWithPlaceholder(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.name,
                onValueChanged = viewModel::updateName,
                placeholder = R.string.full_name,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = VerticalPadding16)

            Text(
                text = stringResource(id = R.string.email_address),
                style = typography.h5,
                color = colors.neutralDark.dark
            )

            Spacer(modifier = VerticalPadding8)

            OutlinedTextWithPlaceholder(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.email,
                onValueChanged = viewModel::updateEmail,
                placeholder = R.string.email_template,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = VerticalPadding16)

            Text(
                text = stringResource(id = R.string.password),
                style = typography.h5,
                color = colors.neutralDark.dark
            )

            Spacer(modifier = VerticalPadding8)

            PasswordOutlinedText(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.password,
                onValueChanged = viewModel::updatePassword,
                placeholder = R.string.create_a_password,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = VerticalPadding8)

            PasswordOutlinedText(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.confirmPassword,
                onValueChanged = viewModel::updateConfirmPassword,
                placeholder = R.string.confirm_password,
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = VerticalPadding8)

            AlreadyHaveAccountClickableText(
                modifier = Modifier.align(Alignment.End),
                onLoginClick = onLoginClick
            )

            Spacer(modifier = VerticalPadding16)

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                RoundedCornerCheckBox(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onCheckChanged = viewModel::updateTermsAndPolicyState,
                    borderColor = colors.neutralLight.darkest,
                    tintColor = colors.highlight.darkest
                )

                Spacer(modifier = HorizontalPadding8)

                TermsAndConditionsClickableText(
                    modifier = Modifier.fillMaxWidth(),
                    onTermsClick = {},
                    onPrivacyPolicyClick = {}
                )
            }

            Spacer(modifier = VerticalPadding16)

            RoundedCornerButton(
                modifier = Modifier.fillMaxWidth(),
                text = R.string.sign_up,
                cornerRadius = 12.dp,
                colors = highlightButtonColors(),
                textColor = colors.neutralLight.lightest,
                onClick = viewModel::onSignUpClicked
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    ComposePracticeTheme {
        SignUpScreen(viewModel = viewModel())
    }
}
