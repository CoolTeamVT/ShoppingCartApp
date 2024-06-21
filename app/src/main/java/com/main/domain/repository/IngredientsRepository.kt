package com.main.domain.repository

import com.main.data.IngredientsDB.IngredientsEntity
import kotlinx.coroutines.flow.Flow

interface IngredientsRepository {
    suspend fun getIngredients(): Flow<List<IngredientsEntity>>
    suspend fun addIngredient(ingredientsEntity: IngredientsEntity)


    //TODO
    //suspend fun getIngredientById(id: Int): IngredientsEntity?
    //suspend fun deleteIngredient(id: Int)
}