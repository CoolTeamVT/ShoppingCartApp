package com.main.domain.models

data class RecipeModel(
    val name: String,
    val grams: Double?,
    val imageUrl: String?
    val ingredients: List<IngredientModel>
)
