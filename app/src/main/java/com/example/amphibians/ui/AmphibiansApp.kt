package com.example.amphibians.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.ui.theme.AmphibiansTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.ui.AmphibiansUiState.Success
import com.example.amphibians.ui.AmphibiansUiState.Loading
import com.example.amphibians.ui.AmphibiansUiState.Error
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.data.Amphibian

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val amphibiansViewModel: AmphibiansViewModel =
                viewModel(factory = AmphibiansViewModel.Factory)
            HomeScreen(amphibiansUiState = amphibiansViewModel.uiState)
        }
    }
}

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
) {

    when (amphibiansUiState) {
        is Loading -> {
            LoadingScreen(modifier = Modifier.fillMaxWidth())
        }

        is Success -> {
            ResultScreen(
                amphibiansList = amphibiansUiState.amphibiansList,
                modifier = modifier.fillMaxWidth()
            )
        }

        is Error -> {
            ErrorScreen(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.error), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TopBar(
    topAppBarTitle: String,
    modifier: Modifier = Modifier
) {
    Text(text = topAppBarTitle)
}

@Composable
fun ResultScreen(
    amphibiansList: List<Amphibian>,
    modifier: Modifier = Modifier
) {
    AmphibianCardsList(
        amphibiansList = amphibiansList,
        modifier = modifier
    )
}

@Composable
fun AmphibianCardsList(
    amphibiansList: List<Amphibian>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(5.dp),
    ) {
        items(amphibiansList) { amphibian ->
            AmphibianCard(
                amphibian = amphibian
            )
        }
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
        HomeScreen(amphibiansUiState = Loading)
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
        AmphibianCardsList(
            amphibiansList = listOf(
                Amphibian(
                    name = "Ambhibian_1",
                    type = "Type_1",
                    description = "Description_1",
                    imgSrc = "Img_1"
                ),
                Amphibian(
                    name = "Amphibian_2",
                    type = "Type_2",
                    description = "Description_2",
                    imgSrc = "Img_2"
                )
            ),
            modifier = Modifier
        )
    }
}