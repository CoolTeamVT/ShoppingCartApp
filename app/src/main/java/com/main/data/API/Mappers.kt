package com.main.data.API

import com.main.data.API.dto.IngredientClass
import com.main.data.API.dto.RecipeClass
import com.main.data.RecipesDB.RecipeDatabaseEntity
import com.main.domain.models.RecipeModel

internal fun RecipeClass.toRecipeEntity() : RecipeDatabaseEntity {
    return RecipeDatabaseEntity(
        id = 0,
        name = label,
        grams = totalWeight,
        imageUrl = image
    )
}

internal fun IngredientClass.toIngredientEntity(){}
