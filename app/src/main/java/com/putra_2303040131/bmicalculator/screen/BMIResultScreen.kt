package com.putra_2303040131.bmicalculator.screen

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
fun BMIResultScreen(bmi: Float, gender: String, onBack: () -> Unit) {
    val category = when (gender.uppercase()) {
        "MALE" -> when (bmi) {
            in 0.0..19.9 -> "UNDERWEIGHT"
            in 20.0..25.9 -> "NORMAL"
            in 26.0..29.9 -> "OVERWEIGHT"
            in 30.0..34.9 -> "OBESITAS KELAS I"
            in 35.0..39.9 -> "OBESITAS KELAS II"
            else -> "OBESITAS KELAS III"
        }

        "FEMALE" -> when (bmi) {
            in 0.0..18.4 -> "UNDERWEIGHT"
            in 18.5..24.4 -> "NORMAL"
            in 24.5..29.9 -> "OVERWEIGHT"
            in 30.0..34.9 -> "OBESITAS KELAS I"
            in 35.0..39.9 -> "OBESITAS KELAS II"
            else -> "OBESITAS KELAS III"
        }
        else -> "UNKNOWN"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E21))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Your Result:", color = Color.White, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = category, color = Color.Green, fontSize = 20.sp)
        Text(text = String.format("%.1f", bmi), color = Color.White, fontSize = 48.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Gender: $gender", color = Color.Gray)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
            Text("BACK", color = Color.White)
        }
    }
}
