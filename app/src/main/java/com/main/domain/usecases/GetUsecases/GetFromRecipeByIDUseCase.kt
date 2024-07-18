package com.main.domain.usecases.GetUsecases

import com.main.domain.models.RecipeModel
import com.main.domain.repositories.RecipesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface GetFromRecipeByIDUseCase {
    suspend fun execute (params: Int) : Flow<RecipeModel>

}
class GetFromRecipeByIDUseCaseImpl @Inject constructor(
    private val recipesRepository: RecipesRepository

    ): BasicGetUsecase<RecipeModel, Int>(), GetFromRecipeByIDUseCase {
    override suspend fun execute(params: Int): Flow<RecipeModel> {
        return recipesRepository.getRecipeById(params)
    }
}