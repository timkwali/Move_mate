package com.timkwali.shipmentapp

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )
    data object Calculate: BottomBarScreen(
        route = "calculate",
        title = "Calculate",
        icon = R.drawable.ic_calculate
    )
    data object Shipment: BottomBarScreen(
        route = "shipment",
        title = "Shipment",
        icon = R.drawable.ic_shipment
    )
}