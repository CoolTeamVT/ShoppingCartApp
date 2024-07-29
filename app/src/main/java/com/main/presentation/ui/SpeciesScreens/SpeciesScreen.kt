package com.main.presentation.ui.SpeciesScreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.main.presentation.ui.HomeScreen.HomeScreenViewModel
import com.main.utils.FontFamilies
import org.jetbrains.annotations.Async

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpeciesScreen(
    navController: NavController,
    viewModel: SpeciesScreenViewModel = hiltViewModel(),
    )
{
    val species = viewModel.species.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var query by remember {
            mutableStateOf("")
        }

        var isActiveSearch by remember {
            mutableStateOf(false)
        }
        
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.03f)
                .background(Color.Black)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Text(
                text = "My recipes",
                fontFamily = FontFamilies.montserratMedium,
                fontSize = 12.sp,
                color = Color.White
            )

            Text(
                text = "Browser",
                fontFamily = FontFamilies.montserratMedium,
                fontSize = 12.sp,
                color = Color.White
            )

            Text(
                text = "Recently eaten",
                fontFamily = FontFamilies.montserratMedium,
                fontSize = 12.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            query = query,
            onQueryChange = {
                query = it
                viewModel.setQuery(query)
            },
            onSearch = {
                isActiveSearch = false
            },
            active = isActiveSearch,
            onActiveChange = {
                isActiveSearch = true
            },
            placeholder = {
                Text(text = "Search fo Recipes")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search icon"
                )
            },
            trailingIcon = {
                if (isActiveSearch) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close",
                        modifier = Modifier
                            .clickable {
                                if (query.isNotEmpty()) {
                                    query = ""
                                } else {
                                    isActiveSearch = false
                                }
                            })
                }
            }
        ) {

        }

        Spacer(modifier = Modifier.height(20.dp))

        val context = LocalContext.current
        LaunchedEffect(key1 = species.loadState) {
            if (species.loadState.refresh is LoadState.Error) {
                Toast.makeText(
                    context,
                    "Error:" + (species.loadState.refresh as LoadState.Error).error.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (species.loadState.refresh is LoadState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            } else {
                SpecieGrid(species = species)
            }
        }
    }
}


@Composable
fun SpecieGrid (
    species: LazyPagingItems<Specie>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp), // Padding around the grid
        verticalArrangement = Arrangement.spacedBy(16.dp), // Vertical spacing between rows
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(species.itemCount) { index ->
            SpecieCard(specie = species[index])
        }
    }
}


@Composable
fun SpecieCard(
    specie: Specie?
) {

    Card(
        modifier = Modifier
            .requiredHeight(188.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = specie?.imageUrl,
                contentDescription = "Image with Loading Indicator",
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = specie?.name ?: "Error",
                modifier = Modifier
                    .padding(6.dp),
                fontSize = 20.sp,
                fontFamily = FontFamilies.montserratMedium
                )
        }
    }
}
