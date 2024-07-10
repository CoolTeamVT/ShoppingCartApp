package com.main.domain.repositories

import com.main.domain.models.MealsModel
import kotlinx.coroutines.flow.Flow

interface MealsRepository {

    suspend fun getMeals(date: String): Flow<List<MealsModel>>
    suspend fun addMeal(mealsModel: MealsModel)
}