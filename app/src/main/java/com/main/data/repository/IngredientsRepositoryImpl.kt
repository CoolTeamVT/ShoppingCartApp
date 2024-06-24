package com.main.data.repository

import com.main.data.local.IngredientsDB.IngredientsDao
import com.main.data.local.IngredientsDB.IngredientsEntity
import com.main.domain.repository.IngredientsRepository
import kotlinx.coroutines.flow.Flow

class IngredientsRepositoryImpl(private val ingredientsDao: IngredientsDao) : IngredientsRepository{
    override suspend fun getIngredients(): Flow<List<IngredientsEntity>> {
        return ingredientsDao.getAllIngredients()
    }

    override suspend fun addIngredient(ingredientsEntity: IngredientsEntity) {
        ingredientsDao.insert(ingredientsEntity)
    }

}