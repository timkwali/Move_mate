package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.animation.AnimatedContent
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
import androidx.compose.foundation.layout.offset
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.theme.ShipmentAppTheme
import com.timkwali.shipmentapp.ui.theme.grey
import com.timkwali.shipmentapp.ui.theme.orange
import com.timkwali.shipmentapp.ui.theme.transparent
import com.timkwali.shipmentapp.ui.utils.noRippleClickable

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
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier,
        ) {
            Row(modifier = Modifier
                .size(50.dp)
                .weight(1f)
            ){
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.height(40.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = "location",
                            tint = Color.White.copy(alpha = 0.6f),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = "Your location", style = MaterialTheme.typography.bodyLarge.copy(color = Color.White.copy(alpha = 0.6f)))
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Wertheimer, Illinois", style = MaterialTheme.typography.titleMedium.copy(color = Color.White, fontSize = 20.sp))
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
        SearchArea { onSearchClick() }
    }
}

@Composable
fun SearchArea(onSearchClick: () -> Unit) {
        TextField(
            enabled = false,
            value = "", onValueChange = {},
            placeholder = {
                Text(
                    text = "Enter the receipt number ...",
                    modifier = Modifier
                        .background(color = transparent),
                    style = MaterialTheme.typography.titleMedium.copy(color = grey),
                    overflow = TextOverflow.Ellipsis
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(48.dp))
                .focusRequester(remember { FocusRequester() })
                .noRippleClickable { onSearchClick() },
            leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = "Search", tint = MaterialTheme.colorScheme.primary) },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedPlaceholderColor = Color.Gray.copy(0.8f),
                unfocusedPlaceholderColor = Color.Gray.copy(0.8f),
            ),
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(orange)
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_flip),
                        contentDescription = "Scanner",
                        tint = Color.White,
                        modifier = Modifier
                            .size(20.dp)
                            .rotate(90f)
                    )
                }
            }
        )
//    }
}

@Preview
@Composable
fun TopSectionPreview() {
    TopSection(onSearchClick = {})
}