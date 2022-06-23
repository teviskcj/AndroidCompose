package com.example.navigationanimation.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.IntSize
import com.example.navigationanimation.ui.FirstScreen
import com.example.navigationanimation.ui.SecondScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

const val slide_horizonal_anim = "horizontal slide in & out"
const val slide_fadein_and_fadeout_anim = "fade in & out"
const val slide_expandin_an_shinkout_anim = "expand in & out"
const val scalein_and_scaleout="scale in & out"

@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val controller = rememberAnimatedNavController()
    val flag = remember {
        mutableStateOf(slide_horizonal_anim)
    }

    /**
     * can put top (sharing all composable)
     * enter used for navigate to
     * pop used for pop back
     */
    AnimatedNavHost(
        navController = controller,
        startDestination = Screen.FistScreen.route,
        enterTransition = {
            enterAnim(flag.value)
        },
        exitTransition = {
            exitAnim(flag.value)
        },
        popEnterTransition = {
            popEnterAnim(flag.value)
        },
        popExitTransition = {
            popExitAnim(flag.value)
        }
    ) {
        composable(Screen.FistScreen.route) {
            FirstScreen(navController = controller, flag = flag)
        }

        composable(Screen.SecondScreen.route) {
            SecondScreen(navController = controller, flag = flag)
        }

        /**
         * navigate correct, go in & go back different direction
         */
        /*composable(
            Screen.FistScreen.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(1000))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(1000))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(1000))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(1000))
            }
        ) {
            FirstScreen(navController = controller, flag = flag)
        }

        composable(Screen.SecondScreen.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(1000))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(1000))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(1000))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(1000))
            }) {
            SecondScreen(navController = controller, flag = flag)
        }*/
    }
}

@ExperimentalAnimationApi
fun enterAnim(flag: String): EnterTransition {
    return when (flag) {
        slide_horizonal_anim -> {
            slideInHorizontally(
                animationSpec = tween(1000),
                initialOffsetX = {
                    it
                }
            )
        }
        slide_fadein_and_fadeout_anim->{
            fadeIn(
                animationSpec = tween(1000),
                initialAlpha = 0f
            )
        }
        slide_expandin_an_shinkout_anim->{
            expandIn(
                animationSpec = tween(1000),
                expandFrom = Alignment.TopStart
            ){
                IntSize(0,0)
            }
        }
        scalein_and_scaleout->{
            scaleIn(
                animationSpec = tween(1000),
                initialScale = 0f,
                transformOrigin = TransformOrigin(0f, 0f)
            )
        }
        else -> {
            slideInHorizontally(
                animationSpec = tween(1000),
                initialOffsetX = {
                    -it
                }
            )
        }
    }
}

@ExperimentalAnimationApi
fun exitAnim(flag: String): ExitTransition {
    return when (flag) {
        slide_horizonal_anim -> {
            slideOutHorizontally(
                animationSpec = tween(1000),
                targetOffsetX = {
                    -it
                }
            )
        }
        slide_fadein_and_fadeout_anim->{
            fadeOut(
                animationSpec = tween(1000),
                targetAlpha = 0f
            )
        }
        slide_expandin_an_shinkout_anim->{
            shrinkOut(
                animationSpec = tween(1000),
                shrinkTowards = Alignment.BottomEnd
            ) {//缩小80%
                it*4/5
            }
        }
        scalein_and_scaleout->{
            scaleOut(
                animationSpec = tween(1000),
                targetScale = 0f,
                transformOrigin = TransformOrigin(1f, 1f)
            )
        }
        else -> {
            slideOutHorizontally(
                animationSpec = tween(1000),
                targetOffsetX = {
                    it
                }
            )
        }
    }
}

@ExperimentalAnimationApi
fun popEnterAnim(flag: String): EnterTransition {
    return when (flag) {
        slide_horizonal_anim -> {
            slideInHorizontally(
                animationSpec = tween(1000),
                initialOffsetX = {
                    -it
                }
            )
        }
        slide_fadein_and_fadeout_anim->{
            fadeIn(
                animationSpec = tween(1000),
                initialAlpha = 0f
            )
        }
        slide_expandin_an_shinkout_anim->{
            expandIn(
                animationSpec = tween(1000),
                expandFrom = Alignment.BottomEnd
            ){
                IntSize(0,0)
            }
        }
        scalein_and_scaleout->{
            scaleIn(
                animationSpec = tween(1000),
                initialScale = 0f,
                transformOrigin = TransformOrigin(1f, 1f)
            )
        }
        else -> {
            slideInHorizontally(
                animationSpec = tween(1000),
                initialOffsetX = {
                    -it
                }
            )
        }
    }
}

@ExperimentalAnimationApi
fun popExitAnim(flag: String): ExitTransition {
    return when (flag) {
        slide_horizonal_anim -> {
            slideOutHorizontally(
                animationSpec = tween(1000),
                targetOffsetX = {
                    it
                }
            )
        }
        slide_fadein_and_fadeout_anim->{
            fadeOut(
                animationSpec = tween(1000),
                targetAlpha = 0f
            )
        }
        slide_expandin_an_shinkout_anim->{
            shrinkOut(
                animationSpec = tween(1000),
                shrinkTowards = Alignment.TopStart
            ) {//缩小80%
                it*4/5
            }
        }
        scalein_and_scaleout->{
            scaleOut(
                animationSpec = tween(1000),
                targetScale = 0f,
                transformOrigin = TransformOrigin(0f, 0f)
            )
        }
        else -> {
            slideOutHorizontally(
                animationSpec = tween(1000),
                targetOffsetX = {
                    it
                }
            )
        }
    }
}