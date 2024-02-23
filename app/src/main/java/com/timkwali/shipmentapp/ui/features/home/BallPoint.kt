package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BallPoint(color: Color = Color(0xFF4aca2d)) {
    Box(
        modifier = Modifier
            .size(8.dp)
            .clip(shape = CircleShape)
            .background(color = color),
    )
}