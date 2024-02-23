package com.timkwali.shipmentapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.timkwali.shipmentapp.BottomBarScreen
import com.timkwali.shipmentapp.ui.theme.grey
import com.timkwali.shipmentapp.ui.utils.bounceClick

@Composable
fun BottomNav(modifier: Modifier = Modifier, navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Calculate,
        BottomBarScreen.Shipment,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    NavigationBar(
        modifier = modifier,
        containerColor = Color.White
    ) {
        screens.forEachIndexed{ index, item ->
            val isSelected = currentDestination?.hierarchy?.any{
                it.route == item.route
            } == true
            val tintColor = if(isSelected) MaterialTheme.colorScheme.primary else grey
            val fontWeight =  if(isSelected) FontWeight.Bold else FontWeight.Normal


//            sealedValues<BottomBarScreen>().sortedBy { it.id }.forEach { item ->
//                val selected = currentDestination?.route == item.route
//                Box(modifier = Modifier
//                    .weight(1f)
//                    .selectable(
//                        selected = selected,
//                        onClick = {
//                            navController.navigate(item.route) {
//                                popUpTo(navController.graph.startDestinationId)
//                                launchSingleTop = true
//                            }
//                        },
//                        enabled = true,
//                        interactionSource = remember { MutableInteractionSource() },
//                        indication = null,
//                    )
//                    .bounceClick()
//                    .clickable {
//                        navController.navigate(item.route) {
//                            popUpTo(navController.graph.startDestinationId)
//                            launchSingleTop = true
//                        }
//                    }) {
//                    Column(verticalArrangement = Arrangement.Center) {
//                        if (selected) {
//                            Divider(color = MaterialTheme.colorScheme.primary, thickness = 4.dp)
//                        } else {
//                            Spacer(modifier = Modifier.size(4.dp))
//                        }
//                        Column(
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .weight(1f)
//                        ) {
//                            Icon(
//                                painter = painterResource(id = item.icon),
//                                contentDescription = null,
//                                tint = if (currentDestination?.route == item.route) MaterialTheme.colorScheme.primary else Color.Gray,
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .align(Alignment.CenterHorizontally)
//                            )
//                            Text(
//                                item.title,
//                                color = if (currentDestination?.route == item.route) MaterialTheme.colorScheme.primary else Color.Gray,
//                                modifier = Modifier
//                                    .fillMaxWidth(),
//                                textAlign = TextAlign.Center
//                            )
//                        }
//                    }
//                }
//            }

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White
                ),
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = "", tint = tintColor)
                },
                label = {
                    Text(text = item.title, style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 14.sp,
                        color = tintColor,
                        fontWeight = fontWeight
                    ))
                }
            )
        }
    }
}

inline fun <reified T> sealedValues(): List<T> {
    return T::class.sealedSubclasses.mapNotNull { it.objectInstance as T }
}