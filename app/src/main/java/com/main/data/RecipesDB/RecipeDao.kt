package com.main.data.RecipesDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(entity = RecipeDatabaseEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipe: RecipeDatabaseEntity)

    @Query("SELECT * FROM recipes_db")
    fun getRecipe(): Flow<List<RecipeDatabaseEntity>>
}