package com.example.amphibians.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.data.Amphibian
import com.example.amphibians.ui.theme.AmphibiansTheme
import com.example.amphibians.utils.ThemePreviews
import com.example.amphibians.utils.debugPlaceholder

@Composable
fun AmphibianCard(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Card {
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Text(
                text = amphibian.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                placeholder = debugPlaceholder(R.drawable.debug_placeholder),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier.fillMaxWidth()
            )
            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}

@ThemePreviews
@Composable
fun AmphibianCardPreviews() {
    AmphibiansTheme {
        AmphibianCard(
            Amphibian(
                name = "Great Basin Spadefoot",
                type = "Toad",
                description = "This toad spends most of its life underground.",
                imgSrc = ""
            )
        )
    }
}