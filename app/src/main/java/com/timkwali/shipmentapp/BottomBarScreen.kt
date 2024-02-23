package com.timkwali.shipmentapp

sealed class BottomBarScreen(
    val id: Int,
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Home: BottomBarScreen(
        id = 0,
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )
    data object Calculate: BottomBarScreen(
        id = 1,
        route = "calculate",
        title = "Calculate",
        icon = R.drawable.ic_calculate
    )
    data object Shipment: BottomBarScreen(
        id = 2,
        route = "shipment",
        title = "Shipment",
        icon = R.drawable.ic_shipment
    )

    data object CostEstimate: BottomBarScreen(
        id = 3,
        route = "costEstimate",
        title = "Cost Estimate",
        icon = R.drawable.ic_calculate
    )

    data object Search: BottomBarScreen(
        id = 4,
        route = "search",
        title = "Search",
        icon = R.drawable.ic_home
    )
}