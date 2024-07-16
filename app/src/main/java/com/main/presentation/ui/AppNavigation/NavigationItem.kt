package com.main.presentation.ui.AppNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.shoppingcartapp.R

sealed class NavigationItem( val route: String, val icon: ImageVector, val title: Int) {
    object Home: NavigationItem("home", Icons.Filled.Home, R.string.home )
    object  Species: NavigationItem("species", Icons.Filled.Restaurant, R.string.species)
    object YourFridge : NavigationItem("your_fridge",Icons.Filled.Kitchen, R.string.your_fridge)
    object ShoppingList: NavigationItem("shoppibg_list", Icons.Filled.ShoppingCart, R.string.shopping_list)
}