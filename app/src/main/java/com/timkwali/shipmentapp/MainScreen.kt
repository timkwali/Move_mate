package com.timkwali.shipmentapp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.timkwali.shipmentapp.ui.BottomNav
import com.timkwali.shipmentapp.ui.features.home.TopSection
import com.timkwali.shipmentapp.ui.utils.AppBarAnimatedVisibility
import com.timkwali.shipmentapp.ui.utils.BottomBarAnimatedVisibility

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute= navBackStackEntry?.destination?.route
    var showBottomBar by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomBarAnimatedVisibility(visibility = showBottomBar) {
                BottomNav(navController = navController)
            }
        }
    ) {
        BottomNavGraph(navController = navController) {
            showBottomBar = it
        }
    }
}