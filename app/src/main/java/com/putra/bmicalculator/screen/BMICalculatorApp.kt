package com.putra.bmicalculator.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController

@Composable
fun BMICalculatorApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "calculator") {
        composable("calculator") { BMICalculatorScreen(navController) }
        composable("result/{bmi}") { backStackEntry ->
            val bmi = backStackEntry.arguments?.getString("bmi")?.toFloatOrNull() ?: 0f
            BMIResultScreen(bmi) { navController.popBackStack() }
        }
    }
}