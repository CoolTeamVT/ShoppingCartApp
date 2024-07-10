package com.main.domain.usecases.GetUsecases

import com.main.domain.models.MealsModel
import com.main.domain.repositories.MealsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetMealsUsecase {
    suspend fun execute(params: String): Flow<List<MealsModel>>
}

class GetMealsUsecaseImpl @Inject constructor(
    private val mealsRepository: MealsRepository
): BasicGetUsecase<List<MealsModel>, String>(), GetMealsUsecase {
    override suspend fun execute(params: String): Flow<List<MealsModel>> {
        return mealsRepository.getMeals(date = params)
    }
}