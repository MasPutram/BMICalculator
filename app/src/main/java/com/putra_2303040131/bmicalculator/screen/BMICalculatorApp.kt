package com.putra_2303040131.bmicalculator.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BMICalculatorApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "calculator") {
        composable("calculator") { BMICalculatorScreen(navController) }
        composable("result/{bmi}") { backStackEntry ->
            val bmi = backStackEntry.arguments?.getString("bmi")?.toFloatOrNull() ?: 0f
            val gender = backStackEntry.arguments?.getString("gender") ?: "MALE"

            BMIResultScreen(bmi = bmi, gender = gender) {
                navController.popBackStack()
            }
        }
    }
}