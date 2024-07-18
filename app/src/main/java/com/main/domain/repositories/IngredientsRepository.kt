package com.main.domain.repositories

import com.main.domain.models.IngredientModel
import kotlinx.coroutines.flow.Flow

interface IngredientsRepository {
    suspend fun getIngredients(recipeId: Int): List<IngredientModel>
    suspend fun addIngredient(ingredientModel: IngredientModel)


    //TODO
    //suspend fun getIngredientById(id: Int): IngredientsEntity?
    //suspend fun deleteIngredient(id: Int)
}