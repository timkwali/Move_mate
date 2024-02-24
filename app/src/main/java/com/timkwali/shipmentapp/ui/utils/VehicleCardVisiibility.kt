package com.timkwali.shipmentapp.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally

@Composable
fun VehicleCardVisibility(
    isVisible: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = isVisible,
        enter =  slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight / 2  },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        )
//                + slideInHorizontally(
//            initialOffsetX = { fullWidth -> fullWidth/8 },
//            animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing)
//        ),
                + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth/4 },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ) + fadeOut(
            targetAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ),
    ) {
        content()
    }
}