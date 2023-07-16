package com.slothdeboss.composepractice.ui.views

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.R
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun RoundedCornerCheckBox(
    isChecked: Boolean = false,
    onCheckChanged: (Boolean) -> Unit = {},
    size: Dp = 24.dp,
    cornerSize: Dp = 4.dp,
    borderColor: Color = Color.Black,
    tintColor: Color = Color.Black
) {
    var checked by rememberSaveable { mutableStateOf(isChecked) }
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(size)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(cornerSize)
            )
            .clickable {
                checked = !checked
                onCheckChanged(checked)
            }
            .padding(4.dp)
    ) {
        if (checked) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = null,
                tint = tintColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    ComposePracticeTheme {
        RoundedCornerCheckBox()
    }
}
