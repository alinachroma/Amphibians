package com.example.amphibians.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.ui.theme.AmphibiansTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.data.Amphibian

@Composable
fun AmphibiansApp(
    viewModel: AmphibiansViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TopBar(topAppBarTitle = "") },
        modifier = modifier,
        content = { paddingValues ->
            HomeScreen(modifier = Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun TopBar(
    topAppBarTitle: String,
    modifier: Modifier = Modifier
) {
    Text(text = topAppBarTitle)
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    AmphibianCardsList()
}

@Composable
fun AmphibianCardsList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(5.dp),
    ) {
    }
}

@Composable
fun AmphibianCard(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = amphibian.name)
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current).build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
        Text(text = amphibian.description)
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibiansAppPreview() {
    AmphibiansTheme {
        AmphibiansApp()
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibianCardPreview() {
    AmphibiansTheme {
        AmphibianCard(
            Amphibian(
                name = "Amarilis",
                type = "Alvina",
                description = "Samnang",
                imgSrc = "Carlisa"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibianCardsListPreview() {
    AmphibiansTheme {
        AmphibianCardsList()
    }
}