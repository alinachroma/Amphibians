package com.example.amphibians.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.data.Amphibian
import com.example.amphibians.ui.theme.AmphibiansTheme
import com.example.amphibians.utils.ThemePreviews

@Composable
fun AmphibianCardsList(
    amphibiansList: List<Amphibian>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        contentPadding = contentPadding,
    ) {
        items(amphibiansList) { amphibian ->
            AmphibianCard(
                amphibian = amphibian
            )
        }
    }
}

@ThemePreviews
@Composable
fun AmphibianCardsListPreview() {
    AmphibiansTheme {
        AmphibianCardsList(
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