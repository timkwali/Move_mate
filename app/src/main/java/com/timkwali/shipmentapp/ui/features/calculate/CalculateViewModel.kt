package com.timkwali.shipmentapp.ui.features.calculate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculateViewModel : ViewModel() {

    var senderLocation by mutableStateOf("")
        private set

    var receiverLocation by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    var box by mutableStateOf("")
        private set


    fun updateSenderLocation(input: String) {
        senderLocation = input
    }

    fun updateReceiverLocation(input: String) {
        receiverLocation = input
    }

    fun updateWeight(input: String) {
        weight = input
    }

    fun updateBox(input: String) {
        box = input
    }

    val categories =
        listOf("Document", "Glass", "Liquid", "Food", "Electronic", "Product", "Others")
}