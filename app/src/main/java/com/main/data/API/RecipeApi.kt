package com.main.data.API

import androidx.annotation.IntRange
import com.main.data.API.dto.QueryClass
import com.main.utils.Constants.DEFAULT_PAGE_SIZE
import com.main.utils.Constants.MAX_PAGE_SIZE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("search")
    suspend fun getRecipes(
        @Query("app_id") apiId : String,
        @Query("app_key") apiKey: String,
        @Query("q") query : String,
        @Query("page") @IntRange page: Int,
        @Query("pageSize") @IntRange(from = 1, to = MAX_PAGE_SIZE.toLong()) pageSize: Int = DEFAULT_PAGE_SIZE,
        ) : Response<QueryClass>
}
