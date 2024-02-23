package com.timkwali.shipmentapp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.timkwali.shipmentapp.ui.BottomNav

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute= navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute == BottomBarScreen.Home.route){
                AnimatedVisibility(visible = currentRoute == BottomBarScreen.Home.route, enter = slideInHorizontally() + fadeIn(), exit = slideOutVertically() + fadeOut()) {
                    BottomNav(navController = navController)
                }
            }
//            BottomNav(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}