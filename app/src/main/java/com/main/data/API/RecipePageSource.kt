package com.main.data.API

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.shoppingcartapp.BuildConfig
import com.main.data.API.dto.QueryClass

class RecipePageSource(
    private val recipeApi: RecipeApi,
    private val query: String
) : PagingSource<Int, QueryClass>(){
    override fun getRefreshKey(state: PagingState<Int, QueryClass>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, QueryClass> {
        if (query.isEmpty()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }

        val page : Int = params.key ?: 1
        val pageSize : Int = params.loadSize

        val response = recipeApi.getRecipes(query = query,
            apiId = BuildConfig.API_ID, apiKey = BuildConfig.API_KEY,
            page = page, pageSize = pageSize)

        if (response.isSuccessful) {
            response.body()
        }
    }
}