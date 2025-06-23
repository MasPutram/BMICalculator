package com.putra_2303040131.bmicalculator.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.putra_2303040131.bmicalculator.ui.theme.CardSelected
import com.putra_2303040131.bmicalculator.ui.theme.CardUnselected

@Composable
fun GenderCard(
    label: String,
    iconResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier // 👈 tambahin ini kayak sebelumnya
) {
    val bgColor = if (isSelected) CardSelected else CardUnselected

    Column(
        modifier = modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(bgColor)
            .clickable(onClick = onClick)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = label,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 18.sp
        )
    }
}
