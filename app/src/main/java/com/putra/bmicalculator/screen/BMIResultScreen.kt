package com.putra.bmicalculator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Your Result",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = category,
            color = when (category) {
                "NORMAL" -> Color.Green
                "UNDERWEIGHT" -> Color.Cyan
                "OVERWEIGHT" -> Color.Yellow
                else -> Color.Red
            },
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = String.format("%.1f", bmi),
            color = Color.White,
            fontSize = 64.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Based on your BMI value",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("BACK", color = Color.White, fontSize = 16.sp)
        }
    }
}
