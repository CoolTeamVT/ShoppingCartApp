package com.main.data.RecipesDB

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface RecipeDao {
    @Insert(entity = RecipeDatabaseEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: RecipeDatabaseEntity)

    @Query("SELECT * FROM recipes_db")
    suspend fun getRecipeById(id: Int): Flow<List<RecipeDatabaseEntity>>?
}