package com.slothdeboss.composepractice.ui.screens.confirmCode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.LocalColors
import com.slothdeboss.composepractice.ui.theme.LocalTypography
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.util.VerticalPadding12
import com.slothdeboss.composepractice.ui.util.VerticalPadding40
import com.slothdeboss.composepractice.ui.util.VerticalPadding8
import com.slothdeboss.composepractice.ui.views.CodeCell
import com.slothdeboss.composepractice.ui.views.RoundedCornerButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConfirmCodeScreen(
    modifier: Modifier = Modifier,
    email: String
) {

    val colors = LocalColors.current
    val typography = LocalTypography.current

    val viewModel = viewModel { ConfirmCodeViewModel() }

    val (secondFocus, thirdFocus, fourthFocus) = remember {
        FocusRequester.createRefs()
    }

    val focusManager = LocalFocusManager.current
    val keyboardManager = LocalSoftwareKeyboardController.current

    Surface(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        color = colors.neutralLight.lightest
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.enter_confirm_code),
                style = typography.h3,
                color = colors.neutralDark.darkest,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = VerticalPadding8)

            Text(
                modifier = Modifier
                    .padding(horizontal = 80.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(
                    id = R.string.code_was_sent_to,
                    formatArgs = arrayOf(email)
                ),
                textAlign = TextAlign.Center,
                style = typography.bodyS,
                color = colors.neutralDark.light
            )

            Spacer(modifier = VerticalPadding40)

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CodeCell(
                    value = viewModel.confirmCode.firstNumber,
                    onValueChange = viewModel::updateFirstNumber,
                    onNextAction = {
                        secondFocus.requestFocus()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                CodeCell(
                    modifier = modifier.focusRequester(secondFocus),
                    value = viewModel.confirmCode.secondNumber,
                    onValueChange = viewModel::updateSecondNumber,
                    onNextAction = {
                        thirdFocus.requestFocus()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                CodeCell(
                    modifier = modifier.focusRequester(thirdFocus),
                    value = viewModel.confirmCode.thirdNumber,
                    onValueChange = viewModel::updateThirdNumber,
                    onNextAction = {
                        fourthFocus.requestFocus()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                CodeCell(
                    modifier = modifier.focusRequester(fourthFocus),
                    value = viewModel.confirmCode.fourthNumber,
                    onValueChange = viewModel::updateFourthNumber,
                    onNextAction = {
                        focusManager.clearFocus()
                        keyboardManager?.hide()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
            }

            Spacer(modifier = Modifier.padding(vertical = (112.5).dp))

            RoundedCornerButton(
                modifier = Modifier.fillMaxWidth(),
                text = R.string.resend_code,
                textColor = colors.highlight.darkest,
                cornerRadius = 0.dp,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.neutralLight.lightest,
                    disabledContainerColor = colors.neutralLight.lightest
                )
            ) {

            }

            Spacer(modifier = VerticalPadding12)

            RoundedCornerButton(
                modifier = Modifier.fillMaxWidth(),
                text = R.string.continue_label,
                textColor = colors.highlight.lightest,
                cornerRadius = 12.dp,
                colors = highlightButtonColors(),
                onClick = viewModel::validateCode
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmCodeScreenPreview() {
    ComposePracticeTheme {
        ConfirmCodeScreen(email = "random@email.com")
    }
}