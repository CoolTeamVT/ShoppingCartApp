package com.main.data.local.RecipeApiDB

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface RecipeApiDao {

    @Upsert
    suspend fun upsertAll(recipes: List<RecipeApiEntity>)

    @Query("SELECT * FROM RecipeApiEntity")
    fun pagingSource(): PagingSource<Int, RecipeApiEntity>

    @Query("DELETE FROM RecipeApiEntity")
    suspend fun clearAll()
}