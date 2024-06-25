package com.main.data.Mappers

import com.main.data.local.FridgeInventoryDB.FridgeInventoryEntity
import com.main.data.local.IngredientsDB.IngredientsEntity
import com.main.data.local.RecipesDB.RecipeEntity
import com.main.data.local.ShoppingListsDB.ShoppingListEntity
import com.main.domain.models.FridgeInventoryModel
import com.main.domain.models.IngredientModel
import com.main.domain.models.RecipeModel
import com.main.domain.models.ShoppingListModel

internal fun RecipeEntity.toRecipeModelWithIngredients(ingredients : List<IngredientsEntity>) : RecipeModel{
    return RecipeModel(
        id = id,
        name = name,
        grams = grams,
        imageUrl = imageUrl,
        ingredients = ingredients.map { it.toIngredientModel() }
    )
}

internal fun RecipeEntity.toRecipeModelWithoutIngredients() : RecipeModel{
    return RecipeModel(
        id = id,
        name = name,
        grams = grams,
        imageUrl = imageUrl,
        ingredients = null
    )
}

internal fun IngredientsEntity.toIngredientModel() : IngredientModel {
    return IngredientModel(
        id = id,
        name = name,
        quantity = quantity,
        measure = measure
    )
}

internal fun FridgeInventoryEntity.toFridgeInventoryModel(): FridgeInventoryModel {
    return FridgeInventoryModel(
        id = id,
        name = name
    )
}

internal fun ShoppingListEntity.toShoppingListModel() : ShoppingListModel {
    return ShoppingListModel(
        id = id,
        data = data,
        name = name
    )
}