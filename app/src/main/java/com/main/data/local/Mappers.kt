package com.main.data.local

import com.main.data.local.IngredientsDB.IngredientsEntity
import com.main.data.local.RecipesDB.RecipeDatabaseEntity
import com.main.domain.models.IngredientModel
import com.main.domain.models.RecipeModel

internal fun RecipeDatabaseEntity.toRecipeModel(ingredients : List<IngredientsEntity>) : RecipeModel{
    return RecipeModel(
        id = id,
        name = name,
        grams = grams,
        imageUrl = imageUrl,
        ingredients = ingredients.map { it.toIngredientModel() }
    )
}

internal fun IngredientsEntity.toIngredientModel() : IngredientModel {
    return IngredientModel(
        id = id,
        name = name,
        grams = grams
    )
}