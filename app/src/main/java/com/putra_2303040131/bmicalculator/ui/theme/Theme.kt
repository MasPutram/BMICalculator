package com.putra_2303040131.bmicalculator.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Purple80,
    secondary = ButtonBlue,
    background = Neutral10,
    onPrimary = Color.White,
    onBackground = Neutral90
)

@Composable
fun BMICalculatorTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
