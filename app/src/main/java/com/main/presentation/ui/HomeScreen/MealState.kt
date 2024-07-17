package com.main.presentation.ui.HomeScreen

sealed class MealState {
    data class MealExists(
        val name: String,
        val recipeId: Int,
    ) : MealState()
    object CategoryDoesNotExist : MealState()
}