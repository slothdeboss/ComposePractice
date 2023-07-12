package com.slothdeboss.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.slothdeboss.composepractice.ui.navigation.ComposePracticeNavHost
import com.slothdeboss.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposePracticeTheme {
                ComposePracticeNavHost(navController = navController)
            }
        }
    }
}
