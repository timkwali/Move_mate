package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.theme.grey
import com.timkwali.shipmentapp.ui.theme.orange

@Composable
fun TrackingSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Tracking", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Shipment Number", style = MaterialTheme.typography.labelSmall.copy(color = Color.Black.copy(alpha = 0.6f), fontSize = 14.sp))
                    Text(text = "NEJ200089934122231", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                }
                Image(painter = painterResource(id = R.drawable.fork_lift), contentDescription = "fork lift icon", modifier = Modifier.size(40.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                Modifier
                    .padding(horizontal = 10.dp)
                    .height(1.dp)
                    .background(grey)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            TrackingItem(
                modifier = Modifier
                .padding(horizontal = 10.dp),
                trackingType = TrackingType.SENDER,
                address = "Atlanta, 5243",
                duration = "2 days -3 days"
            )
            Spacer(modifier = Modifier.height(30.dp))
            TrackingItem(modifier = Modifier
                .padding(horizontal = 10.dp),
                trackingType = TrackingType.RECEIVER,
                address = "Chicago, 6342",
                duration = "Waiting to collect"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                Modifier
                    .height(1.dp)
                    .background(grey)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "add",
                    tint = orange
                )
                Text(text = "Add Stop",
                    style = MaterialTheme.typography.bodyLarge.copy(color = orange, fontWeight = FontWeight.Bold)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
@Preview
fun TrackingSectionPreview() {
    TrackingSection()
}