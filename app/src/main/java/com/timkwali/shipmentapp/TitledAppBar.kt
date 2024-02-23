package com.timkwali.shipmentapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitledAppBar(title: String, onBackClick: ()-> Unit) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }, navigationIcon = {
        IconButton(onClick = onBackClick) {
            Icon(
                Icons.Rounded.KeyboardArrowLeft,
                contentDescription = "Go home"
            )
        }
    }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        navigationIconContentColor = Color.White,
        titleContentColor = Color.White
    )
    )
}

@Composable
@Preview
fun TitledAppBarPreview() {
    TitledAppBar(title = "HomeScreen") {
        
    }
}