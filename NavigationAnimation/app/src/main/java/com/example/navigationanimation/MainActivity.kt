package com.example.navigationanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.navigationanimation.ui.navigation.Navigation
import com.example.navigationanimation.ui.theme.NavigationAnimationTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAnimationTheme {
                Navigation()
            }
        }
    }
}