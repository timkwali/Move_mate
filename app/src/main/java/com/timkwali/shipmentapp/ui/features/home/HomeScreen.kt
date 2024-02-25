package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.timkwali.shipmentapp.BottomBarScreen
import com.timkwali.shipmentapp.ui.features.calculate.CalculateScreen
import com.timkwali.shipmentapp.ui.theme.DirtyWhite
import com.timkwali.shipmentapp.ui.utils.AppBarAnimatedVisibility
import com.timkwali.shipmentapp.ui.utils.ContentAnimatedVisibility

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = modifier
            .background(color = DirtyWhite)
    ) {
        var isContentVisible by remember { mutableStateOf(false) }
        var isAppBarVisible by remember { mutableStateOf(false) }
        var isListVisible by remember { mutableStateOf(false) }
        fun loadContent() {
            isContentVisible = !isContentVisible
        }

        fun loadAppBar() {
            isAppBarVisible = !isAppBarVisible
        }

        var containerState by remember { mutableStateOf(ContainerState.HOME) }
        AnimatedContent(
            modifier = modifier,
            targetState = containerState,
            label = "container transform",
        ) { state ->
            when (state) {
                ContainerState.HOME -> AppBarAnimatedVisibility(visibility = isAppBarVisible) {
                    TopSection(
                        onSearchClick = {
                            containerState = ContainerState.HOME
                            navController.navigate(BottomBarScreen.Search.route)
                        }
                    )
                }

                ContainerState.SEARCH -> SearchScreen(
                    navController = navController,
                    onBack = {
                        containerState = ContainerState.SEARCH
//                        navController.popBackStack()
                    }
                )
            }
        }


//        AppBarAnimatedVisibility(visibility = isAppBarVisible) {
//            TopSection(
//                onSearchClick = { navController.navigate(BottomBarScreen.Search.route) }
//            )
//        }

        Spacer(modifier = Modifier.height(20.dp))

        ContentAnimatedVisibility(visibility = isContentVisible) {
            Column {
                TrackingSection(modifier = Modifier.padding(horizontal = 20.dp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        AvailableVehiclesSection(
            vehicles = vehiclesList,
            isListVisible = isListVisible,
            isAvailableVehiclesVisible = isContentVisible
        )

        LaunchedEffect("") {
            loadAppBar()
            loadContent()
            isListVisible = true
        }
    }
}

enum class ContainerState {
    HOME, SEARCH
}
