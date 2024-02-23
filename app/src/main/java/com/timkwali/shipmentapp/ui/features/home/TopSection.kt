package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.theme.ShipmentAppTheme
import com.timkwali.shipmentapp.ui.theme.orange
import com.timkwali.shipmentapp.ui.theme.transparent

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit
){
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier,
        ) {
            Row(modifier = Modifier
                .size(50.dp)
                .weight(1f)
            ){
                Box(modifier = Modifier
                    .background(Color.White, shape = CircleShape)
                    .size(40.dp)
                    .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ){
                    Image(painter = painterResource(id = R.drawable.person), contentDescription = "notification icon")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.height(40.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = "location",
                            tint = Color.White.copy(alpha = 0.6f),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(text = "Your location", style = MaterialTheme.typography.labelSmall.copy(color = Color.White.copy(alpha = 0.6f), fontSize = 14.sp))
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Wertheimer, Illinois", style = MaterialTheme.typography.labelSmall.copy(color = Color.White, fontSize = 18.sp))
                        Spacer(modifier = Modifier.size(8.dp))
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = "location",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            Box(modifier = Modifier
                .background(Color.White, shape = CircleShape)
                .size(40.dp)
                .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.ic_notification), contentDescription = "person")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(30.dp))
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(30.dp))
                .clickable { onSearchClick() },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(15.dp))
            Icon(imageVector = Icons.Outlined.Search, tint = MaterialTheme.colorScheme.primary, contentDescription = "search icon", modifier = Modifier.size(20.dp))
            Text(
                text = "Enter the receipt number ...",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
                    .background(color = transparent),
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
            )
            Box(modifier = Modifier
                .background(orange, shape = CircleShape)
                .size(40.dp)
                .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_flip), contentDescription = "flip", tint = Color.White, modifier = Modifier.rotate(90f))
            }
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

@Preview
@Composable
fun TopSectionPreview() {
    TopSection(onSearchClick = {})
}