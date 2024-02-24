package com.timkwali.shipmentapp.ui.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable

@Composable
fun AnimatedVisibility(
    isListVisible: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = isListVisible,
        enter = slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ) + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ) + fadeOut(
            targetAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ),
    ) {
        content()
    }
}