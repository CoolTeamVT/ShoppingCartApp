package com.main.data.remote

import com.main.data.remote.dto.QueryDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("search")
    suspend fun getRecipes(
        @Query("app_id") apiId : String,
        @Query("app_key") apiKey: String,
        @Query("q") query : String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        ) : List<QueryDto>
}
