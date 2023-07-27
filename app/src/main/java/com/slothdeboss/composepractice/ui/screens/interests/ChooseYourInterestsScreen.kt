package com.slothdeboss.composepractice.ui.screens.interests

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.components.BoldTitle
import com.slothdeboss.composepractice.ui.components.RoundedCornerButton
import com.slothdeboss.composepractice.ui.components.interests.InterestItem
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.util.VerticalPadding12
import com.slothdeboss.composepractice.ui.util.VerticalPadding40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseYourInterestsScreen(
    viewModel: ChooseYourInterestsViewModel,
    onNext: () -> Unit = {}
) {

    val colors = ComposePracticeTheme.colors
    val typography = ComposePracticeTheme.typography

    val topics by viewModel.interests.collectAsState()
    val isValid by viewModel.isValid.collectAsState()
    val progress by viewModel.process.collectAsState()

    Scaffold(
        containerColor = colors.neutralLight.lightest
    ) { values ->
        Column(
            modifier = Modifier
                .padding(values)
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(8.dp)
                    .clip(CircleShape),
                progress = progress,
                color = colors.highlight.darkest,
                trackColor = colors.neutralLight.medium
            )

            Spacer(modifier = VerticalPadding40)

            BoldTitle(
                modifier = Modifier.fillMaxWidth(),
                resId = R.string.personalise_your_experience
            )

            Spacer(modifier = VerticalPadding12)

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.choose_your_interests),
                style = typography.bodyM,
                color = colors.neutralDark.light
            )

            LazyColumn(
                modifier = Modifier
                    .padding(top = 32.dp, bottom = 16.dp)
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(topics) { index, item ->
                    InterestItem(
                        label = item.name,
                        selected = item.selected,
                        onClick = {
                            viewModel.updateItemState(index)
                        }
                    )
                }
            }

            RoundedCornerButton(
                modifier = Modifier.fillMaxWidth(),
                text = R.string.next,
                colors = highlightButtonColors(),
                cornerRadius = 12.dp,
                onClick = onNext,
                enabled = isValid
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChooseYourInterestsPreview() {
    ComposePracticeTheme {
        ChooseYourInterestsScreen(viewModel = viewModel())
    }
}