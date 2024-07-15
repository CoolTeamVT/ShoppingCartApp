package com.main.presentation.ui.AppNavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavController){
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Species,
        NavigationItem.YourFridge,
        NavigationItem.ShoppingList
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach{ item ->
            BottomNavigationItem(
               icon = {
                   Icon(
                       imageVector = item.icon,
                       contentDescription = stringResource(item.title)
                   )
               },
                label = {
                    Text(stringResource(item.title))
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}