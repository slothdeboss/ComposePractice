package com.slothdeboss.composepractice.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(88.dp),
        painter = painterResource(id = R.drawable.ic_google),
        contentDescription = null,
    )
}

@Preview(showBackground = true)
@Composable
fun LogoPreview() {
    ComposePracticeTheme {
        Logo()
    }
}