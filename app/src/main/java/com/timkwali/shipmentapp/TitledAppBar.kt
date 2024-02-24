package com.timkwali.shipmentapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timkwali.shipmentapp.ui.features.shipment.CustomTabRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitledAppBar(
    title: String,
    animateTopBar: Boolean,
    onBackClick: ()-> Unit
) {
    var animateAppBar by remember { mutableStateOf(false) }
    val appBarHeight: Dp by animateDpAsState(
        targetValue = if (animateAppBar) 55.dp else 185.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "appBarHeight"
    )

    LaunchedEffect(key1 = "") {
        animateAppBar = true
    }

    CenterAlignedTopAppBar(
//        modifier = Modifier.height(appBarHeight),
        title = {
        AnimatedVisibility(
            visible = animateTopBar,
            enter = slideInVertically(
                initialOffsetY = { h -> h },
                animationSpec = tween(durationMillis = 500)
            ) + fadeIn(
                tween(500),
            ),
            exit = slideOutVertically(tween(durationMillis = 500)) + fadeOut(tween(500))
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }, navigationIcon = {
        AnimatedVisibility(
            visible = animateTopBar,
            enter = slideInHorizontally(
                initialOffsetX = { w -> -w },
                animationSpec = tween(durationMillis = 500)
            ) + fadeIn(
                tween(500),
            ),
            exit = slideOutHorizontally(tween(durationMillis = 500)) + fadeOut(tween(500))
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "Go home"
                )
            }
        }

    }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        navigationIconContentColor = Color.White,
        titleContentColor = Color.White
    )
    )
}

@Composable
@Preview
fun TitledAppBarPreview() {
    TitledAppBar(title = "HomeScreen", animateTopBar = true, ) {

    }
}