package com.timkwali.shipmentapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.timkwali.shipmentapp.R

// Set of Material typography styles to start with
val linikSans = FontFamily(
    Font(R.font.liniksans_black, FontWeight.Black),
    Font(R.font.liniksans_bold, FontWeight.Bold),
    Font(R.font.liniksans_regular, FontWeight.Normal),
    Font(R.font.liniksans_light, FontWeight.Light),
    Font(R.font.liniksans_thin, FontWeight.Thin)
)

val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = linikSans,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
        ),
    titleLarge = TextStyle(
        fontFamily = linikSans,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    labelSmall = TextStyle(
        fontFamily = linikSans,
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
    )
)