package com.example.navigationanimation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigationanimation.ui.navigation.Screen

@Composable
fun SecondScreen(
    navController: NavController,
    flag: MutableState<String>
) {
    val showdialog = remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(0.5.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center,

                ) {
                Text(
                    text = "Second Screen",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 36.sp
                )
            }

            Button(onClick = {
                navController.navigate(Screen.FistScreen.route)
            }) {
                Text(
                    text = "Go To First Screen"
                )
            }

            Button(onClick = {
                showdialog.value = true
            }) {
                Text(text = "Switch Animation")
            }
        }
        ShowDialog(showdialog = showdialog, flag)
    }
}