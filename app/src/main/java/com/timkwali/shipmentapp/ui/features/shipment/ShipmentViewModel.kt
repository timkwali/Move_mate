package com.timkwali.shipmentapp.ui.features.shipment

import androidx.lifecycle.ViewModel
import com.timkwali.shipmentapp.data.listOfShipmentStatus

class ShipmentViewModel : ViewModel() {
    fun getUpdatedStatusLabelList(selectedId: Int): List<ShipmentStatus> {
        val selectedStatusLabel =
            ShipmentStatusLabel.entries.find { label -> label.id == selectedId }
                ?: ShipmentStatusLabel.ALL

        return if (selectedStatusLabel == ShipmentStatusLabel.ALL)
            listOfShipmentStatus
        else
            listOfShipmentStatus.filter { it.status == selectedStatusLabel }
    }
}