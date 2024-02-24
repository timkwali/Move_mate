package com.timkwali.shipmentapp.ui.features.shipment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.theme.DarkBlue
import com.timkwali.shipmentapp.ui.theme.LightGrey

@Composable
fun ShipmentStatusItem(item: ShipmentStatus) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color.White)
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color.Gray.copy(0.1f))
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Icon(
                imageVector = item.status.icon,
                tint = item.status.color,
                contentDescription = item.status.tag,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = item.status.tag, fontSize = 12.sp, color = item.status.color,
            )
        }
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = item.message,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = DarkBlue
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(text = item.details, fontSize = 14.sp, color = LightGrey, lineHeight = 18.sp)
                Spacer(modifier = Modifier.size(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = item.amount,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .padding(6.dp)
                            .size(8.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color.Gray.copy(0.5f)),
                    )
                    Text(text = item.date, fontSize = 12.sp, color = DarkBlue)
                }
            }
            Image(
                painter = painterResource(id = R.drawable.box),
                modifier = Modifier.size(80.dp),
                contentDescription = "",
            )
        }
    }
}
