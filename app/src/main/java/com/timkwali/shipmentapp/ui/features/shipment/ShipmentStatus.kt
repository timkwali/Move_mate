package com.timkwali.shipmentapp.ui.features.shipment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.theme.orange

data class ShipmentStatus(
    val status: ShipmentStatusLabel,
    val message: String,
    val details: String,
    val amount: String,
    val date: String,
)

enum class ShipmentStatusLabel(
    val id: Int,
    val title: String,
    val tag: String,
    val icon: Int,
    val color: Color,
) {
    ALL(0, "All", "all", R.drawable.ic_add, Color.Magenta),
    COMPLETED(1, "Completed", "completed", R.drawable.ic_check, Green),
    PENDING_ORDER(2, "Pending order", "pending", R.drawable.ic_pending, orange),
    IN_PROGRESS(3, "In-progress", "in-progress", R.drawable.ic_inprogress, Green),
    LOADING(4, "Loading", "loading", R.drawable.ic_loading, Color.Blue),
    CANCELLED(5, "Cancelled", "cancelled", R.drawable.ic_cancel, Color.Red),
}
