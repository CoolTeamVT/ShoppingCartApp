package com.main.data.repositories

import com.main.data.Mappers.fromModelToEntity
import com.main.data.Mappers.toMealsModel
import com.main.data.local.MealsDB.MealsDao
import com.main.data.local.MealsDB.MealsEntity
import com.main.domain.models.MealsModel
import com.main.domain.repositories.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val mealsDao: MealsDao
): MealsRepository {
    override suspend fun getMeals(date: String): Flow<List<MealsModel>> {
        return withContext(Dispatchers.IO) {
            return@withContext mealsDao.getMealOnDate(date).map { entityList ->
                entityList.map { entity ->
                    entity.toMealsModel()
                }
            }
        }
    }

    override suspend fun addMeal(mealsModel: MealsModel) {
        withContext(Dispatchers.IO) {
            mealsDao.insertMeal(mealsModel.fromModelToEntity())
        }
    }
}