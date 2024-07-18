package com.main.data.repositories

import com.main.data.local.RecipesDB.RecipeDao
import com.main.data.Mappers.fromModelToEntity
import com.main.data.Mappers.toRecipeModelWithIngredients
import com.main.data.Mappers.toRecipeModelWithoutIngredients
import com.main.data.local.RecipesDB.RecipeEntity
import com.main.domain.models.RecipeModel
import com.main.domain.repositories.RecipesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipesDao: RecipeDao,
    private val ingredientsRepository: IngredientsRepositoryImpl
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

    override suspend fun getRecipeById(id: Int) : Flow<RecipeModel> {
        return withContext(Dispatchers.IO) {
            val ingredientsFlow = ingredientsRepository.getIngredients(id).map { it.fromModelToEntity() }
            val recipeFlow = recipesDao.getRecipeById(id).map { entity ->
                entity.toRecipeModelWithIngredients(ingredientsFlow)
            }
            return@withContext recipeFlow
        }
    }

    override suspend fun addRecipe(recipeModel: RecipeModel) {
        withContext(Dispatchers.IO) {
            recipesDao.insertRecipe(recipeModel.fromModelToEntity())
        }
    }


}