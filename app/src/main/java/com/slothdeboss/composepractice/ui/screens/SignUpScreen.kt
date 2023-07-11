package com.slothdeboss.composepractice.ui.screens

import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.RoundedCornerShape12
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.util.HorizontalPadding12
import com.slothdeboss.composepractice.ui.util.VerticalPadding16
import com.slothdeboss.composepractice.ui.util.VerticalPadding24
import com.slothdeboss.composepractice.ui.util.VerticalPadding8
import com.slothdeboss.composepractice.ui.views.OutlinedTextWithPlaceholder
import com.slothdeboss.composepractice.ui.views.PasswordOutlinedText
import com.slothdeboss.composepractice.ui.views.RoundedCornerCheckBox
import com.slothdeboss.composepractice.ui.views.TermsAndConditionsSpannable

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {

    val colors = ComposePracticeTheme.colors

    val (emailFocus, passwordFocus, confirmPasswordFocus) = remember {
        FocusRequester.createRefs()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = colors.neutralLight.lightest)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.sign_up),
                style = ComposePracticeTheme.typography.h3,
                color = colors.neutralDark.darkest
            )

            Spacer(modifier = VerticalPadding8)

            Text(
                text = stringResource(id = R.string.create_account_to_start),
                style = ComposePracticeTheme.typography.bodyS,
                color = colors.neutralDark.light
            )

            Spacer(modifier = VerticalPadding24)

            Text(
                text = stringResource(id = R.string.name),
                style = ComposePracticeTheme.typography.h5,
                color = colors.neutralDark.dark
            )

            Spacer(modifier = VerticalPadding8)

            OutlinedTextWithPlaceholder(
                modifier = Modifier.fillMaxWidth(),
                onValueChanged = {},
                placeholder = R.string.full_name,
                keyboardActions = KeyboardActions(
                    onNext = { emailFocus.requestFocus() }
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = VerticalPadding16)

            Text(
                text = stringResource(id = R.string.email_address),
                style = ComposePracticeTheme.typography.h5,
                color = colors.neutralDark.dark
            )

            Spacer(modifier = VerticalPadding8)

            OutlinedTextWithPlaceholder(
                modifier = Modifier
                    .focusRequester(emailFocus)
                    .fillMaxWidth(),
                onValueChanged = {},
                placeholder = R.string.email_template,
                keyboardActions = KeyboardActions(
                    onNext = { passwordFocus.requestFocus() }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = VerticalPadding16)

            Text(
                text = stringResource(id = R.string.password),
                style = ComposePracticeTheme.typography.h5,
                color = colors.neutralDark.dark
            )

            Spacer(modifier = VerticalPadding8)

            PasswordOutlinedText(
                modifier = Modifier
                    .focusRequester(passwordFocus)
                    .fillMaxWidth(),
                onValueChanged = {},
                placeholder = R.string.create_a_password,
                keyboardActions = KeyboardActions(
                    onNext = { confirmPasswordFocus.requestFocus() }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = VerticalPadding8)

            PasswordOutlinedText(
                modifier = Modifier
                    .focusRequester(confirmPasswordFocus)
                    .fillMaxWidth(),
                onValueChanged = {},
                placeholder = R.string.confirm_password,
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = VerticalPadding24)

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                RoundedCornerCheckBox(
                    onCheckChanged = { checked ->
                        Log.e("TAG", "isChecked $checked")
                    },
                    borderColor = colors.neutralLight.darkest,
                    tintColor = colors.highlight.darkest
                )

                Spacer(modifier = HorizontalPadding12)

                TermsAndConditionsSpannable(
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = VerticalPadding16)

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape12,
                colors = highlightButtonColors(),
                onClick = { Log.e("TAG", "on button click") }
            ) {
                Text(text = stringResource(id = R.string.sign_up))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    ComposePracticeTheme {
        SignUpScreen()
    }
}