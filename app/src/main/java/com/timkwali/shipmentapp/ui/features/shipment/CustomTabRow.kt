package com.timkwali.shipmentapp.ui.features.shipment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.timkwali.shipmentapp.data.listOfShipmentStatus
import com.timkwali.shipmentapp.ui.theme.DimOrange
import com.timkwali.shipmentapp.ui.theme.orange
import com.timkwali.shipmentapp.ui.utils.bounceClick

@Composable
fun CustomTabRow(selectedId: MutableIntState) {
    ScrollableTabRow(
        selectedTabIndex = selectedId.intValue,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        edgePadding = 12.dp,
        indicator = { tabPositions ->
            if (selectedId.intValue < tabPositions.size) {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedId.intValue]),
                    color = orange.copy(alpha = 0.6f)
                )
            }
        }
    ) {
        ShipmentStatusLabel.entries.forEach { status ->
            val isSelected = selectedId.intValue == status.id
            val count =
                if (status == ShipmentStatusLabel.ALL) listOfShipmentStatus.size else listOfShipmentStatus.count { it.status == status }
            Tab(
                selected = isSelected,
                onClick = { selectedId.intValue = status.id },
                modifier = Modifier.bounceClick()
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = status.title,
                        color = if (isSelected) Color.White else Color.White.copy(0.6f),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                color = if (isSelected) DimOrange else Color.White.copy(
                                    0.3f
                                )
                            )
                    ) {
                        Text(
                            text = "$count",
                            modifier = Modifier.padding(horizontal = 10.dp),
                            color = if (isSelected) Color.White else Color.White.copy(
                                0.4f
                            )
                        )
                    }

                }
            }
        }
    }
}