package com.main.presentation.ui.RecipeDetailScreen


sealed class RecipeDetailScreenEvent {
    data class LoadDataEvent(val id: Int) : RecipeDetailScreenEvent()
}