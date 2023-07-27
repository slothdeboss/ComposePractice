package com.slothdeboss.composepractice.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.components.BoldTitle
import com.slothdeboss.composepractice.ui.components.Logo
import com.slothdeboss.composepractice.ui.components.RoundedCornerButton
import com.slothdeboss.composepractice.ui.components.tabs.DotTabRow
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.util.VerticalPadding16
import com.slothdeboss.composepractice.ui.util.VerticalPadding8
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = koinViewModel(),
    navigateNext: () -> Unit = {}
) {
    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.neutralLight.lightest
    ) { values ->
        Column(
            modifier = Modifier.padding(values)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f)
                    .background(color = colors.highlight.lightest),
                verticalArrangement = Arrangement.Center
            ) {
                Logo(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(24.dp)
            ) {

                val pageCount = 3
                var currentPage by remember { mutableStateOf(0) }

                DotTabRow(
                    pageCount = pageCount,
                    currentPage = currentPage,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = VerticalPadding16)

                BoldTitle(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.getOnboardingItem(currentPage).title,
                )

                Spacer(modifier = VerticalPadding8)

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.getOnboardingItem(currentPage).description,
                    style = typography.bodyS,
                    color = colors.neutralDark.light
                )

                Spacer(modifier = Modifier.weight(1f))

                val buttonText = if (currentPage != pageCount - 1) {
                    R.string.next
                } else {
                    R.string.continue_label
                }

                RoundedCornerButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = buttonText,
                    colors = highlightButtonColors(),
                    cornerRadius = 12.dp
                ) {
                    if (currentPage < pageCount - 1) {
                        currentPage += 1
                    } else {
                        viewModel.setOnboardingIsShown()
                        navigateNext()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    ComposePracticeTheme {
        OnboardingScreen(viewModel())
    }
}
