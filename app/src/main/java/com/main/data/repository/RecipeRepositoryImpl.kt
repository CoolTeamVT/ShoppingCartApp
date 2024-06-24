package com.main.data.repository

import com.main.data.local.RecipesDB.RecipeDao
import com.main.data.local.RecipesDB.RecipeDatabaseEntity
import com.main.domain.repository.RecipesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class RecipeRepositoryImpl(private val recipesDao: RecipeDao): RecipesRepository {
    override suspend fun addRecipe(recipe: RecipeDatabaseEntity) {
        recipesDao.insertRecipe(recipe)
    }

    override suspend fun getRecipes(): Flow<List<RecipeDatabaseEntity>> {
        return recipesDao.getRecipe()
    }
}