package com.timkwali.shipmentapp.ui.features.home

import kotlinx.coroutines.flow.flowOf

data class Item(
    val name: String,
    val id: String,
    val origin: String,
    val destination: String
)


val itemList = flowOf(
    listOf(
        Item(
            "Macbook pro M2",
            "#NE43857340857904",
            "Paris",
            "Morocco"
        ),
        Item(
            "Summer linen jacket",
            "#NEJ20089934122231",
            "Barcelona",
            "Paris"
        ),
        Item(
            "Tapered-fit jeans AW",
            "#NEJ35870264978659",
            "Colombia",
            "Paris"
        ),
        Item(
            "Slim fit jeans AW",
            "#NEJ35870264978659",
            "Bogota",
            "Dhaka"
        ),
        Item(
            "Office setup desk",
            "#NEJ23481570754963",
            "France",
            "German"
        ),
    )
)
