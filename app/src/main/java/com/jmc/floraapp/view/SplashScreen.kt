package com.jmc.floraapp.view


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.jmc.floraapp.R
import com.jmc.floraapp.navigation.Screen
import com.jmc.floraapp.utils.Constants.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 500, easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        delay(SPLASH_SCREEN_DURATION)
        navController.popBackStack()
        navController.navigate(Screen.LoginScreen.route)
    }

    viewSplash()
}

@Preview(showBackground = true)
@Composable
fun viewSplash() {
    Surface(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.splash_bg),
            contentDescription = "Splash bg",
            contentScale = ContentScale.FillWidth
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_splash_logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop
            )
        }

    }
}