package com.main.data.repositories

import com.main.data.local.IngredientsDB.IngredientsDao
import com.main.data.Mappers.fromModelToEntity
import com.main.data.Mappers.toIngredientModel
import com.main.domain.models.IngredientModel
import com.main.domain.repositories.IngredientsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class IngredientsRepositoryImpl(
    private val ingredientsDao: IngredientsDao
) : IngredientsRepository{
    override suspend fun getIngredients(): Flow<List<IngredientModel>> {
        return withContext(Dispatchers.IO) {
            return@withContext ingredientsDao.getAllIngredients().map { entityList->
                entityList.map { entity ->
                    entity.toIngredientModel()
                }
            }
        }
    }

    override suspend fun addIngredient(ingredientModel: IngredientModel) {
        withContext(Dispatchers.IO) {
            ingredientsDao.insert(ingredientModel.fromModelToEntity())
        }
    }

}