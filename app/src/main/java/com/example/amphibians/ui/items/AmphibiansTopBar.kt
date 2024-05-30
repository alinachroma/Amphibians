package com.example.amphibians.ui.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TopBar(
    topAppBarTitle: String,
    modifier: Modifier = Modifier
) {
    Text(text = topAppBarTitle)
}