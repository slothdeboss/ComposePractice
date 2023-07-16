package com.slothdeboss.composepractice.ui.screens.getUserEmail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
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
import com.slothdeboss.composepractice.ui.util.VerticalPadding16
import com.slothdeboss.composepractice.ui.util.VerticalPadding24
import com.slothdeboss.composepractice.ui.util.VerticalPadding4
import com.slothdeboss.composepractice.ui.util.VerticalPadding8
import com.slothdeboss.composepractice.ui.views.BoldTitle
import com.slothdeboss.composepractice.ui.views.OutlinedTextWithPlaceholder
import com.slothdeboss.composepractice.ui.views.RoundedCornerButton

@Composable
fun GetUserEmailScreen(
    modifier: Modifier = Modifier,
    navigateWithEmail: (email: String) -> Unit = {},
    onBackPressed: () -> Unit = {}
) {

    val colors = LocalColors.current
    val typography = LocalTypography.current

    val emailFocus = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    val viewModel = viewModel { GetUserEmailViewModel() }

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BoldTitle(resId = R.string.enter_your_email)

            Spacer(modifier = VerticalPadding8)

            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = stringResource(id = R.string.enter_your_email_to_send_code_message),
                style = typography.bodyM,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = VerticalPadding8)

            OutlinedTextWithPlaceholder(
                modifier = Modifier
                    .focusRequester(emailFocus)
                    .fillMaxWidth(),
                value = viewModel.email,
                onValueChanged = viewModel::updateEmail,
                placeholder = R.string.email_template,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = VerticalPadding24)

            RoundedCornerButton(
                modifier = Modifier.fillMaxWidth(),
                text = R.string.continue_label,
                cornerRadius = 12.dp,
                colors = highlightButtonColors(),
                onClick =  {
                    focusManager.clearFocus()
                    if (viewModel.email.isNotBlank()) {
                        navigateWithEmail(viewModel.email)
                    }
                }
            )

            Spacer(modifier = VerticalPadding4)

            RoundedCornerButton(
                modifier = Modifier.fillMaxWidth(),
                text = R.string.back,
                textColor = colors.highlight.darkest,
                cornerRadius = 0.dp,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.neutralLight.lightest,
                    disabledContainerColor = colors.neutralLight.lightest
                ),
                onClick = onBackPressed
            )

            LaunchedEffect(Unit) {
                emailFocus.requestFocus()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetUserEmailScreenPreview() {
    ComposePracticeTheme {
        GetUserEmailScreen()
    }
}