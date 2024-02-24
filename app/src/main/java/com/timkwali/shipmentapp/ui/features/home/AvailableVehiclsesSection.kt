package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.utils.AnimatedVisibility
import com.timkwali.shipmentapp.ui.utils.ContentAnimatedVisibility
import com.timkwali.shipmentapp.ui.utils.VehicleCardVisibility

@Composable
fun AvailableVehiclesSection(
    modifier: Modifier = Modifier,
    vehicles: List<Vehicle>,
    isListVisible: Boolean,
    isAvailableVehiclesVisible: Boolean
) {
    val freightItemsXOffset: Dp by animateDpAsState(
        targetValue = if (isAvailableVehiclesVisible) 0.dp else 40.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "freightItemsXOffset"
    )
    val freightItemsYOffset: Dp by animateDpAsState(
        targetValue = if (isAvailableVehiclesVisible) 0.dp else 100.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "freightItemsXOffset"
    )
    val freightAlpha: Float by animateFloatAsState(
        targetValue = if (isAvailableVehiclesVisible) 1f else 0.1f,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "freightItemsXOffset"
    )

    Column(
        modifier = modifier
    ) {
        ContentAnimatedVisibility(isAvailableVehiclesVisible) {
            Text(modifier = Modifier.padding(start = 20.dp), text = "Available Vehicles", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            Modifier
                .fillMaxWidth()
                .offset(x = freightItemsXOffset, y = freightItemsYOffset)
                .alpha(freightAlpha),
            contentPadding = PaddingValues(start = 20.dp)
        ) {
            items(items = vehicles) {
                FreightItem(
                    name = it.name,
                    status = it.status,
                    image = it.image,
                    isListVisible = isListVisible,
                )
                Spacer(Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun FreightItem(
    modifier: Modifier = Modifier,
    name: String,
    status: String,
    image: Int,
    isListVisible: Boolean,
) {
        Column(
            modifier = modifier
                .width(150.dp)
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
        ) {
            Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp), text = name, style = MaterialTheme.typography.labelSmall.copy(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.W500), overflow = TextOverflow.Ellipsis, maxLines = 1)
            Text(modifier = Modifier.padding(horizontal = 10.dp), text = status, style = MaterialTheme.typography.labelSmall.copy(color = Color.Black.copy(alpha = 0.6f), fontSize = 14.sp), overflow = TextOverflow.Ellipsis, maxLines = 1)
            Box(
                Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .clipToBounds()
            ) {
                AnimatedVisibility(isListVisible = isListVisible) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "freight image",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
}

@Composable
@Preview
fun AvailableVehiclesSectionPreview() {
//    AvailableVehiclesSection(vehicles = vehiclesList)
}

data class Vehicle(
    val name: String,
    val status: String,
    val image: Int
)

val vehiclesList = listOf(
    Vehicle("Ocean Freight", "International", R.drawable.ship),
    Vehicle("Cargo Freight", "Reliable", R.drawable.truck),
    Vehicle("Air Freight", "International", R.drawable.plane),
    Vehicle("Rail Freight", "Reliable", R.drawable.train),
)