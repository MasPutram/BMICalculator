package com.putra.bmicalculator.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "bmi_calculator") {
        composable("bmi_calculator") {
            BMICalculatorScreen(navController)
        }
        composable(
            route = "bmi_result/{bmi}",
            arguments = listOf(navArgument("bmi") { type = NavType.FloatType })
        ) { backStackEntry ->
            val bmi = backStackEntry.arguments?.getFloat("bmi") ?: 0f
            BMIResultScreen(
                bmi = bmi,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
