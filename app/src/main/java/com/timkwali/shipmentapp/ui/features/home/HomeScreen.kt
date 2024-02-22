package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timkwali.shipmentapp.ui.theme.screenBackground

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = screenBackground)
    ) {
        TopSection(onSearchClick = {})
        Spacer(modifier = Modifier.height(20.dp))
        TrackingSection(modifier = Modifier.padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(20.dp))
        AvailableVehiclesSection(vehicles = vehiclesList)
    }
}