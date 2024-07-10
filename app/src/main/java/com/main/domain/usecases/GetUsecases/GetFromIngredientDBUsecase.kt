package com.main.domain.usecases.GetUsecases

import com.main.domain.models.IngredientModel
import com.main.domain.repositories.IngredientsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetFromIngredientDBUsecase {
    suspend fun execute (params: None) : Flow<List<IngredientModel>>
}

class GetFromIngredientDBUsecaseImpl @Inject constructor(
    private val ingredientsRepository: IngredientsRepository
) : BasicGetUsecase<List<IngredientModel>, None>(), GetFromIngredientDBUsecase {
    override suspend fun execute(params: None): Flow<List<IngredientModel>> {
        return ingredientsRepository.getIngredients()
    }

}