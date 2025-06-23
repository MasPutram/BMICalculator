package com.putra_2303040131.bmicalculator.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeightSlider(height: Float, onHeightChange: (Float) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1D1E33))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("HEIGHT (cm)", color = Color.Gray)
        Text("${height.toInt()}", color = Color.White, fontSize = 24.sp)
        Slider(
            value = height,
            onValueChange = onHeightChange,
            valueRange = 100f..220f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Magenta
            )
        )
    }
}
