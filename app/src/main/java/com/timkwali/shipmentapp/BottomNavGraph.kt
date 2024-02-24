package com.timkwali.shipmentapp

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.timkwali.shipmentapp.ui.features.calculate.CalculateScreen
import com.timkwali.shipmentapp.ui.features.calculate.CostEstimateScreen
import com.timkwali.shipmentapp.ui.features.home.HomeScreen
import com.timkwali.shipmentapp.ui.features.home.SearchScreen
import com.timkwali.shipmentapp.ui.features.shipment.ShipmentScreen

@Composable
fun BottomNavGraph(navController: NavHostController, showBottomBar: (state: Boolean) -> Unit){

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None }
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
            showBottomBar(true)
        }

        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(navController = navController, onBack = {  })
            showBottomBar(false)
        }

        composable(route = BottomBarScreen.Calculate.route) {
            CalculateScreen(navController = navController)
            showBottomBar(false)
        }

        composable(route = BottomBarScreen.Shipment.route) {
            ShipmentScreen(navController = navController)
            showBottomBar(false)
        }

        composable(route = BottomBarScreen.CostEstimate.route) {
            CostEstimateScreen(navController = navController)
            showBottomBar(false)
        }
    }
}