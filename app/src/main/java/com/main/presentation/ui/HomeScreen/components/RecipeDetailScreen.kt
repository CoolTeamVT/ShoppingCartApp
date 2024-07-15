package com.main.presentation.ui.HomeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.main.presentation.viewModels.RecipeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(navController: NavController, recipeId: Int, viewModel: RecipeViewModel = hiltViewModel()){

/* val recipe by viewModel.recipe.collectAsState()

    LaunchedEffect(recipeId){
        recipeId?.let {
            viewModel.loadRecipe(it.toInt())
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recipe Detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.back),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
     Column {

     }
    }*/







     val recipes =viewModel.recipes.collectAsState()
     val recipe = viewModel.getRecipeById(recipeId)
    Column {
        Text(text = "Recipe Details for ID: $recipeId")
        recipe?.let {
            Text(text = "Name: ${it.name}")
            Text(text = "Ingredients: ${it.ingredients?.joinToString()}")
            // other details
        } ?: run {
            Text(text = "Recipe not found")
        }
    }
}