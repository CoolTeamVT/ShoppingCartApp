package com.main.domain.repositories

import com.main.domain.models.RecipeModel
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    suspend fun getRecipes(): Flow<List<RecipeModel>>
    suspend fun addRecipe(recipeModel: RecipeModel)
    //TODO
    //suspend fun getRecipeById(id: Int): RecipeDatabaseEntity?
    //suspend fun deleteRecipe(id: Int)
}