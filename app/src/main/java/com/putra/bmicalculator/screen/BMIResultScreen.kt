package com.putra.bmicalculator.screen

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
fun BMIResultScreen(bmi: Float, onBack: () -> Unit) {
    val category = when {
        bmi < 18.5 -> "UNDERWEIGHT"
        bmi in 18.5..24.9 -> "NORMAL"
        bmi in 25.0..29.9 -> "OVERWEIGHT"
        else -> "OBESE"
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
        Text(text = "Your body condition based on your BMI", color = Color.Gray)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
            Text("BACK", color = Color.White)
        }
    }
}
