package com.main.domain.usecases.GetUsecases

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.main.data.Mappers.toRecipeModelWithIngredients
import com.main.data.local.RecipeApiDB.RecipeApiEntity
import com.main.domain.models.RecipeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetFromApiUsecase {
    fun execute() : Flow<PagingData<RecipeModel>>
}

class GetFromApiUsecaseImpl @Inject constructor(
    private val pager: Pager<Int, RecipeApiEntity>
): GetFromApiUsecase {
    override fun execute() : Flow<PagingData<RecipeModel>> {
        return pager.flow.map { pagingData -> pagingData.map { it.toRecipeModelWithIngredients() } }
    }
}