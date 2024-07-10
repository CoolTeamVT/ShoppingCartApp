package com.main.domain.usecases.GetUsecases

import com.main.domain.models.RecipeModel
import com.main.domain.repositories.RecipesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetFromRecipeDBUsecase{
    suspend fun execute (params: None) : Flow<List<RecipeModel>>
}

class GetFromRecipeDBUsecaseImpl @Inject constructor(
    private val recipesRepository: RecipesRepository
): BasicGetUsecase<List<RecipeModel>, None>(), GetFromRecipeDBUsecase {
    override suspend fun execute(params: None): Flow<List<RecipeModel>> {
        return recipesRepository.getRecipes()
    }
}