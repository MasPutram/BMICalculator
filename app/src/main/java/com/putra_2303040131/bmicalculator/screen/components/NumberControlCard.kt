package com.putra_2303040131.bmicalculator.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import com.putra_2303040131.bmicalculator.ui.theme.CardSelected

@Composable
fun NumberControlCard(
    label: String,
    value: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier // <--- biar bisa dikontrol dari luar
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(CardSelected)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "$value", color = Color.White, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onDecrement) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kurangi",
                    tint = Color.White
                )
            }
            IconButton(onClick = onIncrement) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Tambah",
                    tint = Color.White
                )
            }
        }
    }
}
