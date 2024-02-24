package com.timkwali.shipmentapp.ui.features.calculate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.timkwali.shipmentapp.TitledAppBar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.timkwali.shipmentapp.BottomBarScreen
import com.timkwali.shipmentapp.R

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculateViewModel = viewModel(),
    navController: NavController
) {
    var animateTopBar by remember { mutableStateOf(false) }

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
        CalculateBody(paddingValues = paddingValues, viewModel = viewModel, navController)
    }

    LaunchedEffect(key1 = "") {
        animateTopBar = true
    }
}

@Composable
fun CalculateBody(
    paddingValues: PaddingValues,
    viewModel: CalculateViewModel,
    navController: NavController
) {
    Column(
        Modifier.fillMaxHeight(),
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
                                Icons.Outlined.Send,
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
                                Icons.Outlined.ArrowDropDown,
                                contentDescription = "",
                                modifier = Modifier.padding(horizontal = 8.dp),
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
                                Icons.Outlined.Settings,
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
            CustomTextField(
                textValue = viewModel.box,
                onValChange = { viewModel.updateBox(it) },
                placeHolder = "Box",
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.box),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(30.dp)
                    )
                },
                backgroundColor = Color.White,
                modifier = Modifier.shadow(elevation = 4.dp)
            )
            // Drop down panel
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Categories", style = MaterialTheme.typography.titleLarge)
            Text(text = "What are you sending?", color = Color.Gray)
            FilterChipGroup(items = viewModel.categories)
        }
        ActionButton("Calculate") {
            navController.navigate(BottomBarScreen.CostEstimate.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}