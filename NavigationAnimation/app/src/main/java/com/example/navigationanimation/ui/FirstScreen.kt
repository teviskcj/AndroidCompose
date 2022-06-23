package com.example.navigationanimation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.navigationanimation.ui.navigation.*

val amins = mutableListOf(
    slide_horizonal_anim,
    slide_fadein_and_fadeout_anim,
    slide_expandin_an_shinkout_anim,
    scalein_and_scaleout
)

@Composable
fun FirstScreen(
    navController: NavController,
    flag: MutableState<String>
) {
    val showdialog = remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
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
                    text = "First Screen",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 36.sp
                )
            }

            Button(onClick = {
                navController.navigate(Screen.SecondScreen.route)
            }) {
                Text(
                    text = "Go To Second Screen"
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

@Composable
fun ShowDialog(showdialog: MutableState<Boolean>, flag: MutableState<String>) {
    if (showdialog.value) {
        Dialog(
            onDismissRequest = {
                showdialog.value = false
            },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                amins.forEach {
                    Column(
                        Modifier
                            .width(300.dp)
                            .height(55.dp)
                            .background(MaterialTheme.colors.background)
                            .clickable {
                                flag.value = it
                                showdialog.value = false
                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f), contentAlignment = Alignment.Center){
                            Text(text = it)
                        }
                        Divider()
                    }
                }
            }

        }
    }
}