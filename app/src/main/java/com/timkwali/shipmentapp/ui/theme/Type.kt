package com.timkwali.shipmentapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.timkwali.shipmentapp.R

// Set of Material typography styles to start with
val proxima = FontFamily(
    Font(R.font.proxima_nova_soft_medium, FontWeight.Black),
    Font(R.font.proxima_nova_soft_bold, FontWeight.Bold),
    Font(R.font.proxima_nova_soft_regular, FontWeight.Normal),
    Font(R.font.proxima_nova_soft_regular, FontWeight.Light),
    Font(R.font.proxima_nova_soft_regular, FontWeight.Thin)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = proxima,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = proxima,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = proxima,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = proxima,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = proxima,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = proxima,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
    ),


)