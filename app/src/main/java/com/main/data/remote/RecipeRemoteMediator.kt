package com.main.data.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.shoppingcartapp.BuildConfig
import com.main.data.local.RecipeApiDB.RecipeApiDB
import com.main.data.local.RecipeApiDB.RecipeApiEntity
import retrofit2.HttpException
import toRecipeEntity
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class RecipeRemoteMediator(
    private val database: RecipeApiDB,
    private val recipeApi: RecipeApi,
    private val query: String?
): RemoteMediator<Int, RecipeApiEntity>(){

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RecipeApiEntity>,
    ): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            Log.d("Test", "I am here")
            val recipes = recipeApi.getRecipes(
                apiId = BuildConfig.API_ID,
                apiKey = BuildConfig.API_KEY,
                query = query,
                page = loadKey,
                pageSize = state.config.pageSize
            ).hits.map { HitDto ->
                    HitDto.recipe
            }

            database.withTransaction {
                if(loadType == LoadType.REFRESH){
                    database.dao.clearAll()
                }

                val recipeEntities = recipes.map {it.toRecipeEntity()}
                database.dao.upsertAll(recipeEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = recipes.isEmpty()
            )


        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}