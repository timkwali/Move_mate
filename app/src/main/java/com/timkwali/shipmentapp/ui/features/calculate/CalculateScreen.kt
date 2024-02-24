package com.timkwali.shipmentapp.ui.features.calculate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.timkwali.shipmentapp.TitledAppBar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.timkwali.shipmentapp.BottomBarScreen
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.theme.DarkBlue
import com.timkwali.shipmentapp.ui.theme.grey
import com.timkwali.shipmentapp.ui.theme.transparent
import com.timkwali.shipmentapp.ui.utils.ContentAnimatedVisibility

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculateViewModel = viewModel(),
    navController: NavController
) {
    var animateTopBar by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = "") {
        animateTopBar = true
    }

    Scaffold(
        topBar = {
            TitledAppBar(
                title = "Calculate",
                onBackClick = {
                    navController.popBackStack()
                },
                animateTopBar = animateTopBar
            )
        }
    ) { paddingValues ->
        CalculateBody(
            paddingValues = paddingValues,
            viewModel = viewModel,
            navController = navController,
            animateWholeBody = animateTopBar
        )
    }
}

@Composable
fun CalculateBody(
    paddingValues: PaddingValues,
    viewModel: CalculateViewModel,
    navController: NavController,
    animateWholeBody: Boolean
) {
    Column(
        Modifier.fillMaxHeight(),
    ) {
        AnimatedVisibility(
            visible = animateWholeBody,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight - 1000 },
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
            Column(
                Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(text = "Destination", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.size(12.dp))
                // Add Card with 3 entries
                Surface(
                    modifier = Modifier
                        .shadow(elevation = 7.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .padding(16.dp)
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        CustomTextField(
                            textValue = viewModel.senderLocation,
                            onValChange = { newVal -> viewModel.updateSenderLocation(newVal) },
                            placeHolder = "Sender location",
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_panel),
                                    contentDescription = "",
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    tint = Color.Gray
                                )
                            },
                        )
                        CustomTextField(
                            textValue = viewModel.receiverLocation,
                            onValChange = { newVal -> viewModel.updateReceiverLocation(newVal) },
                            placeHolder = "Receiver location",
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_panel),
                                    contentDescription = "",
                                    modifier = Modifier.padding(horizontal = 8.dp).rotate(180f),
                                    tint = Color.Gray
                                )
                            },
                        )

                        CustomTextField(
                            textValue = viewModel.weight,
                            onValChange = { newVal -> viewModel.updateWeight(newVal) },
                            placeHolder = "Approx weight",
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_scale),
                                    contentDescription = "",
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    tint = Color.Gray
                                )
                            },
                        )
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Packaging", style = MaterialTheme.typography.titleLarge)
                Text(text = "What are you sending?", color = Color.Gray)
                Spacer(modifier = Modifier.size(8.dp))
                Surface(
                    modifier = Modifier
                        .shadow(elevation = 7.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .height(56.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .fillMaxWidth()
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.box),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(30.dp)
                        )
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(vertical = 12.dp)
                                .width(1.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Box",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .background(transparent)
                                .weight(1f)
                        )
                        Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = "arrow", tint = DividerDefaults.color)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
                // Drop down panel
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Categories", style = MaterialTheme.typography.titleLarge)
                Text(text = "What are you sending?", color = Color.Gray)
            }
        }

        AnimatedVisibility(
            modifier = Modifier.padding(horizontal = 16.dp),
            visible = animateWholeBody,
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
            FilterChipGroup(items = viewModel.categories)
        }

        Spacer(modifier = Modifier.weight(1f))


        AnimatedVisibility(
            visible = animateWholeBody,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight},
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ) + fadeIn(
                initialAlpha = 0f,
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ) + fadeOut(
                targetAlpha = 0f,
                animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
            ),
        ) {
            ActionButton(text = "Calculate", modifier = Modifier) {
                navController.navigate(BottomBarScreen.CostEstimate.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}