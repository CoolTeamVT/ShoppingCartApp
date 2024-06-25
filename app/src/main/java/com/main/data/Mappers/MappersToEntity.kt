package com.main.data.Mappers

import com.main.data.local.FridgeInventoryDB.FridgeInventoryEntity
import com.main.data.local.IngredientsDB.IngredientsEntity
import com.main.data.local.RecipesDB.RecipeEntity
import com.main.data.local.ShoppingListsDB.ShoppingListEntity
import com.main.domain.models.FridgeInventoryModel
import com.main.domain.models.IngredientModel
import com.main.domain.models.RecipeModel
import com.main.domain.models.ShoppingListModel

internal fun FridgeInventoryModel.fromModelToEntity()
: FridgeInventoryEntity {
    return FridgeInventoryEntity(
        id = this.id,
        name = this.name
    )
}

internal fun IngredientModel.fromModelToEntity(): IngredientsEntity {
    return IngredientsEntity(
        id = this.id,
        name = this.name,
        quantity =  this.quantity,
        measure = this.measure,
        null,
        null,
        null
    )
}

internal fun RecipeModel.fromModelToEntity(): RecipeEntity {
    return RecipeEntity(
        id = this.id,
        name = this.name,
        grams = this.grams,
        imageUrl = this.imageUrl
    )
}

internal fun ShoppingListModel.fromModelToEntity(): ShoppingListEntity {
    return ShoppingListEntity(
        id = this.id,
        name = this.name,
        data = this.data
    )
}