package com.timkwali.shipmentapp.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.timkwali.shipmentapp.BottomBarScreen
import com.timkwali.shipmentapp.ui.theme.grey

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
        modifier = modifier
    ) {
        screens.forEachIndexed{ index, item ->
            val isSelected = currentDestination?.hierarchy?.any{
                it.route == item.route
            } == true
            val tintColor = if(isSelected) MaterialTheme.colorScheme.primary else grey
            val fontWeight =  if(isSelected) FontWeight.Bold else FontWeight.Normal

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route)
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