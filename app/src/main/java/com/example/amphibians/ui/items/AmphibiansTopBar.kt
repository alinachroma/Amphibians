package com.example.amphibians.ui.items

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.amphibians.R
import com.example.amphibians.ui.theme.AmphibiansTheme
import com.example.amphibians.utils.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansTopBar(
    topAppBarTitle: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.background),
        title = {
            Text(
                text = topAppBarTitle,
                style = MaterialTheme.typography.headlineLarge,
                modifier = modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium))
            )
        }
    )

}

@ThemePreviews
@Composable
fun AmphibiansTopBarPreviews() {
    AmphibiansTheme {
        AmphibiansTopBar(topAppBarTitle = "Amphibians")
    }
}