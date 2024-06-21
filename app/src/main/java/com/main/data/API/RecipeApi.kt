package com.main.data.API

import com.main.data.API.dto.QueryClass
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("search")
    suspend fun getRecipes(
        @Query("app_id") apiId : String,
        @Query("app_key") apiKey: String,
        @Query("q") query : String
    ) : QueryClass
}
