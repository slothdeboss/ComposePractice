package com.slothdeboss.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme
import com.slothdeboss.composepractice.ui.theme.HighlightDarkest
import com.slothdeboss.composepractice.ui.theme.HighlightLight
import com.slothdeboss.composepractice.ui.theme.RoundedCornerShape12
import com.slothdeboss.composepractice.ui.theme.highlightButtonColors
import com.slothdeboss.composepractice.ui.views.BoldTitle
import com.slothdeboss.composepractice.ui.views.OutlinedTextWithPlaceholder
import com.slothdeboss.composepractice.ui.views.PasswordOutlinedText
import com.slothdeboss.composepractice.ui.views.RegisterNowSpannable
import com.slothdeboss.composepractice.ui.views.RoundedButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Surface(
        modifier = modifier.fillMaxSize(),
        color = HighlightLight
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .align(Alignment.Bottom)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(start = 24.dp, end = 24.dp, top = 40.dp)
            ) {
                BoldTitle(resId = R.string.welcome)
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextWithPlaceholder(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { value -> email = value },
                    placeholder = R.string.email_address
                )
                Spacer(modifier = Modifier.padding(0.dp, 8.dp))
                PasswordOutlinedText(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { value -> password = value },
                    placeholder = R.string.password
                )
                Spacer(modifier = Modifier.padding(0.dp, 8.dp))
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    style = MaterialTheme.typography.labelLarge,
                    color = HighlightDarkest
                )
                Spacer(modifier = Modifier.padding(0.dp, 8.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape12,
                    colors = highlightButtonColors(),
                    onClick = {}
                ) {
                    Text(text = stringResource(id = R.string.login))
                }
                Spacer(modifier = Modifier.padding(0.dp, 4.dp))
                RegisterNowSpannable(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Divider(
                    modifier = Modifier.padding(0.dp, 24.dp),
                    thickness = 1.dp,
                    color = Color.Gray
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.continue_with),
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.padding(0.dp, 8.dp),)
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    RoundedButton(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        size = 40,
                        icon = R.drawable.ic_google,
                        color = Color.Red,
                        tintColor = Color.White
                    )
                    RoundedButton(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        size = 40.dp,
                        icon = R.drawable.ic_apple,
                        color = Color.Black,
                        tintColor = Color.White
                    )
                    RoundedButton(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        size = 40.dp,
                        icon = R.drawable.ic_facebook,
                        color = Color.Blue,
                        tintColor = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        LoginScreen()
    }
}