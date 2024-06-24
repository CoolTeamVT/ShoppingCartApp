package com.main.data.local.RecipesDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(entity = RecipeEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM recipes_db")
    fun getRecipe(): Flow<List<RecipeEntity>>
}