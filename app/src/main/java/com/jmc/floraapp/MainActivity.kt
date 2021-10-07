package com.jmc.floraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.jmc.floraapp.navigation.Navigation
import com.jmc.floraapp.ui.theme.FloraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FloraAppTheme {
                // A surface container using the 'background' color from the theme
                InitApplicationContent()
            }
        }
    }
}

@Composable
fun InitApplicationContent() {
    Surface(color = MaterialTheme.colors.background) {
        Navigation()
    }
}

