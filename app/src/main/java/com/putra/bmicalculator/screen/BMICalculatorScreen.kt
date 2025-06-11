package com.putra.bmicalculator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.putra.bmicalculator.screen.components.GenderCard
import com.putra.bmicalculator.screen.components.HeightSlider
import com.putra.bmicalculator.screen.components.NumberControlCard
import com.putra.bmicalculator.R

@Composable
fun BMICalculatorScreen(navController: NavController) {
    var selectedGender by remember { mutableStateOf("MALE") }
    var height by remember { mutableStateOf(160f) }
    var weight by remember { mutableStateOf(60) }
    var age by remember { mutableStateOf(20) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E21))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "BMI Calculator",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Gender Selection
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GenderCard(
                label = "FEMALE",
                iconResId = R.drawable.female,
                isSelected = selectedGender == "FEMALE",
                onClick = { selectedGender = "FEMALE" },
                modifier = Modifier.weight(1f)
            )
            GenderCard(
                label = "MALE",
                iconResId = R.drawable.male,
                isSelected = selectedGender == "MALE",
                onClick = { selectedGender = "MALE" },
                modifier = Modifier.weight(1f)
            )
        }

        // Height Slider
        HeightSlider(height = height) { height = it }

        // Weight & Age Controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NumberControlCard(
                label = "WEIGHT",
                value = weight,
                onIncrement = { weight++ },
                onDecrement = { if (weight > 1) weight-- },
                modifier = Modifier.weight(1f)
            )
            NumberControlCard(
                label = "AGE",
                value = age,
                onIncrement = { age++ },
                onDecrement = { if (age > 1) age-- },
                modifier = Modifier.weight(1f)
            )
        }

        // Calculate Button
        Button(
            onClick = {
                val heightInMeter = height / 100
                val bmi = weight / ((height / 100) * (height / 100))
                navController.navigate("bmi_result/${bmi}")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("CALCULATE", color = Color.White)
        }
    }
}
