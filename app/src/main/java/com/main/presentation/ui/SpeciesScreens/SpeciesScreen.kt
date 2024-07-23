package com.main.presentation.ui.SpeciesScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.main.utils.FontFamilies

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpeciesScreen(
    navController: NavController
){
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
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
        
        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            query = query,
            onQueryChange = {
                query = it
            } ,
            onSearch = {
                isActiveSearch = false
            },
            active = isActiveSearch ,
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
                if (isActiveSearch){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close",
                        modifier = Modifier
                            .clickable {
                                if(query.isNotEmpty()){
                                    query = ""
                                }else{
                                    isActiveSearch = false
                                }
                            })
                }
            }
        ) {

        }

        val items = listOf(
            Recipe("Hello","https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"),
            Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"), Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"),
            Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"), Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"),
            Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"), Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"),
            Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"), Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"),
            Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"), Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"),
            Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"), Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"),
            Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg"), Recipe("Good", "https://s12.stc.all.kpcdn.net/family/wp-content/uploads/2024/01/reczepty-poke-kotorye-mozhno-prigotovit-doma-960-560x420.jpg")

        )
        Spacer(modifier = Modifier.height(8.dp))
        
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp)
        ){
            itemsIndexed(items){ _, item ->
                RecipeItem(item = item)
            }
        }
    }
}

@Composable
fun RecipeItem(
    item: Recipe
){
    Column {
        AsyncImage(
                model = item.recipeImageUrl,
                contentDescription = item.name,
                modifier = Modifier
            )

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = item.name,
            fontSize = 20.sp
        )
    }
}

data class Recipe(
    val name: String,
    val recipeImageUrl: String
)
@Preview(showBackground = true)
@Composable
fun Test(){
    SpeciesScreen(navController = rememberNavController())
}

