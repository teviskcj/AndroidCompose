package com.example.checkdob.ui.datepicker

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.checkdob.R
import com.example.checkdob.ui.components.rippleClickable

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DatePickerScreen() {
    val viewModel: DatePickerViewModel = viewModel()
    val state = viewModel.state
    val date = state.date.value
    val constellation = state.constellation.value
    val icon = state.icon.value
    val loading = state.loading.value
    // Fetching the Local Context
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .border(0.5.dp, Color.White)
                    .rippleClickable { viewModel.selectDateTime(context) }
            ) {
                Text(
                    text = date,
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterStart)
                )

                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(20.dp, 20.dp)
                        .align(Alignment.CenterEnd),
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            if (icon != 0) {
                Box {
                    Crossfade(
                        targetState = constellation,
                        animationSpec = tween(durationMillis = 3000)
                    ) { value ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .background(Color.Black)
                            )

                            Text(
                                text = value,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontSize = 36.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )

                        }
                    }

                    AnimatedContent(targetState = icon,
                        transitionSpec = {
                            if (targetState > initialState) {
                                upColorTransition()
                            } else {
                                downColorTransition()
                            }.using(SizeTransform(clip = false))
                        }
                    ) { iconInt ->
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(100.dp)
                            ) {
                                Icon(
                                    painter = painterResource(iconInt),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(36.dp),
                                    tint = Color.White
                                )
                            }

                        }
                    }
                }
            }

            /*Image(
                painter = painterResource(id = background),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            )*/
        }
    }

}

fun <T> animationSpec() = tween<T>(
    durationMillis = 3000,
    easing = LinearOutSlowInEasing
)

@ExperimentalAnimationApi
private fun downColorTransition() =
    slideInHorizontally(
        initialOffsetX = { fullWidth -> -fullWidth },
        animationSpec = animationSpec()
    ) + fadeIn(
        animationSpec = animationSpec()
    ) with slideOutVertically(
        targetOffsetY = { fullHeight -> fullHeight },
        animationSpec = animationSpec()
    ) + fadeOut(animationSpec = animationSpec())

@ExperimentalAnimationApi
private fun upColorTransition() =
    slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth },
        animationSpec = animationSpec()
    ) + fadeIn(
        animationSpec = animationSpec()
    ) with slideOutVertically(
        targetOffsetY = { fullHeight -> -fullHeight },
        animationSpec = animationSpec()
    ) + fadeOut(animationSpec = animationSpec())

