package com.main.presentation.ui.AppNavigation

import HomeScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.main.presentation.ui.HomeScreen.components.RecipeDetailScreen
import com.main.presentation.ui.ShoppingListScreens.ShoppingListScreen
import com.main.presentation.ui.SpeciesScreens.SpeciesScreen
import com.main.presentation.ui.YourFridgeScreens.YourFridgeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavigationItem.Home.route) { HomeScreen(navController) }
            composable(NavigationItem.Species.route) { SpeciesScreen(navController) }
            composable(NavigationItem.YourFridge.route) { YourFridgeScreen(navController) }
            composable(NavigationItem.ShoppingList.route) { ShoppingListScreen(navController) }
            composable(
                route = "recipe_detail/{recipeId}",
                arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
            ){backStackEntry ->
                val recipeId = backStackEntry.arguments?.getInt("recipeId")
                recipeId?.let {
                    RecipeDetailScreen(navController, recipeId)
                }
            }
        }
    }
}
