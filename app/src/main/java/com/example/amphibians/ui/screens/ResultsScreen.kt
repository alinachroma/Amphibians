package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.amphibians.data.Amphibian
import com.example.amphibians.ui.items.AmphibianCardsList
import com.example.amphibians.ui.theme.AmphibiansTheme
import com.example.amphibians.utils.ThemePreviews

@Composable
fun ResultsScreen(
    amphibiansList: List<Amphibian>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    AmphibianCardsList(
        amphibiansList = amphibiansList,
        contentPadding = contentPadding,
        modifier = modifier
    )
}

@ThemePreviews
@Composable
fun ResultsScreenPreview() {
    AmphibiansTheme {
        ResultsScreen(
            amphibiansList = listOf(
                Amphibian(
                    name = "Great Basin Spadefoot",
                    type = "Toad",
                    description = "This toad spends most of its life underground.",
                    imgSrc = ""
                ),
                Amphibian(
                    name = "Roraima Bush",
                    type = "Toad",
                    description = "This toad is typically found in South America.",
                    imgSrc = ""
                )
            )
        )
    }
}