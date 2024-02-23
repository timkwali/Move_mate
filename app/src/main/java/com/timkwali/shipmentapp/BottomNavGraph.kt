package com.timkwali.shipmentapp

import androidx.compose.runtime.Composable
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
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(route = BottomBarScreen.Calculate.route) {
            CalculateScreen(navController = navController)
        }

        composable(route = BottomBarScreen.Shipment.route) {
            ShipmentScreen(navController = navController)
        }

        composable(route = BottomBarScreen.CostEstimate.route) {
            CostEstimateScreen(navController = navController)
        }
    }
}