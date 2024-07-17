package com.main.presentation.ui.AppNavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.main.presentation.ui.theme.MealFrameColor
import com.main.presentation.ui.theme.SelectedBottomNavigationIcon
import com.main.presentation.ui.theme.UnselectedBottomNavigationIcon
import com.main.utils.Dimens


@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier
){
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Species,
        NavigationItem.YourFridge,
        NavigationItem.ShoppingList
    )

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = MealFrameColor
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach { item ->
            Box() {
                this@BottomNavigation.BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(item.title),
                            modifier = Modifier
                                .size(Dimens.bottomNavIconSize)
                        )
                    },
                    label = {

                        Text(
                            text = stringResource(item.title),
                            fontSize = Dimens.bottomNavTextSize,
                            fontWeight = FontWeight.Medium,
                            softWrap = false,
                            maxLines = 1,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                        )
                    },
                    selected = currentRoute == item.route,
                    selectedContentColor = SelectedBottomNavigationIcon,
                    unselectedContentColor = UnselectedBottomNavigationIcon,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    modifier = Modifier
                        .padding(start = Dimens.bottomNavPaddingStart,
                            end = Dimens.bottomNavPaddingEnd,
                            top = Dimens.bottomNavPaddingTop,
                            bottom = Dimens.bottomNavPaddingBottom
                        )

                )
            }
            }
        }
    }


@Preview
@Composable
fun CheckBottomNavigationBar(){
    BottomNavigationBar(navController = rememberNavController())
}