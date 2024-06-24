package com.main.domain.repository

import com.main.data.local.RecipesDB.RecipeDatabaseEntity
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    suspend fun getRecipes(): Flow<List<RecipeDatabaseEntity>>
    suspend fun addRecipe(recipe: RecipeDatabaseEntity)
    //TODO
    //suspend fun getRecipeById(id: Int): RecipeDatabaseEntity?
    //suspend fun deleteRecipe(id: Int)
}