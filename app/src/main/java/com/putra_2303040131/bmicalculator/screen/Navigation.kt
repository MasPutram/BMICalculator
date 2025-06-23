package com.putra_2303040131.bmicalculator.screen

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
            route = "result/{bmi}/{gender}",
            arguments = listOf(
                navArgument("bmi") { type = NavType.StringType },
                navArgument("gender") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val bmi = backStackEntry.arguments?.getString("bmi")?.toFloatOrNull() ?: 0f
            val gender = backStackEntry.arguments?.getString("gender") ?: "MALE"
            BMIResultScreen(bmi = bmi, gender = gender) {
                navController.popBackStack()
            }
        }
    }
}
