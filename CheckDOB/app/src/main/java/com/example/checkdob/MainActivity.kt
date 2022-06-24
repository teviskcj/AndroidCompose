package com.example.checkdob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.checkdob.ui.datepicker.DatePickerScreen
import com.example.checkdob.ui.theme.CheckDOBTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckDOBTheme {
                DatePickerScreen()
            }
        }
    }
}