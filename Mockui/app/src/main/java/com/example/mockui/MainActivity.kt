package com.example.mockui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mockui.ui.datepicker.DatePickerScreen
import com.example.mockui.ui.theme.MockuiTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MockuiTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DatePickerScreen()
                }
            }
        }
    }
}