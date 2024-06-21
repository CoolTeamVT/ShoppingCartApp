package com.main.data.remote

import com.main.data.remote.dto.IngredientClass
import com.main.data.remote.dto.RecipeClass
import com.main.data.local.IngredientsDB.IngredientsEntity
import com.main.data.local.RecipesDB.RecipeDatabaseEntity

internal fun RecipeClass.toRecipeEntity() : RecipeDatabaseEntity {
    return RecipeDatabaseEntity(
        id = 0,
        name = label,
        grams = totalWeight,
        imageUrl = image
    )
}

internal fun IngredientClass.toIngredientEntity() : IngredientsEntity {
    return IngredientsEntity(
        id = 0,
        name = food,
        grams = quantity,
        recipeId = null,
        shoppingListId = null,
        fridgeInventoryId = null
    )
}
