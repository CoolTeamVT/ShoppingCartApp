package com.main.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.shoppingcartapp.BuildConfig
import com.main.data.local.utils.toRecipeModelWithIngredients
import com.main.domain.models.RecipeModel
import com.main.utils.Constants
import retrofit2.HttpException

class RecipePageSource(
    private val recipeApi: RecipeApi,
    private val query: String
) : PagingSource<Int, RecipeModel>(){
    override fun getRefreshKey(state: PagingState<Int, RecipeModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipeModel> {
        if (query.isEmpty()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }

        val pageNumber : Int = params.key ?: 1
        val pageSize : Int = params.loadSize.coerceAtMost(Constants.MAX_PAGE_SIZE)

        val response = recipeApi.getRecipes(query = query,
            apiId = BuildConfig.API_ID, apiKey = BuildConfig.API_KEY,
            page = pageNumber, pageSize = pageSize)

        try {
            if (response.isSuccessful) {
                val recipes = response.body()!!.hits.map { it.recipe.toRecipeEntity()
                    .toRecipeModelWithIngredients(it.recipe.ingredients
                        .map {
                            it.toIngredientEntity() }
                    )
                }
                val nextPageNumber = if (recipes.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                return LoadResult.Page(recipes, prevPageNumber, nextPageNumber)
            }
            else {
                return LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }
}