package com.main.domain.usecases.GetUsecases

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.main.data.Mappers.toRecipeModelWithIngredients
import com.main.data.local.RecipeApiDB.RecipeApiDB
import com.main.data.local.RecipeApiDB.RecipeApiEntity
import com.main.data.remote.RecipeApi
import com.main.data.remote.RecipeRemoteMediator
import com.main.domain.models.RecipeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetFromApiUsecase {
    fun execute(query:String?) : Pager<Int, RecipeApiEntity>
}

@OptIn(ExperimentalPagingApi::class)
class GetFromApiUsecaseImpl @Inject constructor(
    private val apiDb: RecipeApiDB,
    private val recipeApi: RecipeApi
): GetFromApiUsecase {
    override fun execute(query:String?) : Pager<Int, RecipeApiEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = RecipeRemoteMediator(
            database = apiDb,
            recipeApi = recipeApi,
            query = query
        ),
        pagingSourceFactory = {
            apiDb.dao.pagingSource()
        })
    }
}