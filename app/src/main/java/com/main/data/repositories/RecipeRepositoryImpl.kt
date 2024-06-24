package com.main.data.repositories

import com.main.data.local.RecipesDB.RecipeDao
import com.main.data.local.utils.fromModelToEntity
import com.main.data.local.utils.toRecipeModelWithoutIngredients
import com.main.domain.models.RecipeModel
import com.main.domain.repositories.RecipesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val recipesDao: RecipeDao
): RecipesRepository {
    override suspend fun getRecipes(): Flow<List<RecipeModel>> {
        return withContext(Dispatchers.IO) {
            return@withContext recipesDao.getRecipe().map { entityList ->
                entityList.map { entity ->
                    entity.toRecipeModelWithoutIngredients()
                }
            }
        }
    }
    override suspend fun addRecipe(recipeModel: RecipeModel) {
        withContext(Dispatchers.IO) {
            recipesDao.insertRecipe(recipeModel.fromModelToEntity())
        }
    }
}