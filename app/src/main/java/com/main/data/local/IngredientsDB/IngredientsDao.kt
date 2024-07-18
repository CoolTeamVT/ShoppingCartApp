package com.main.data.local.IngredientsDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientsDao {
    @Insert
    fun insert(ingredient: IngredientsEntity)

    @Query("SELECT * FROM ingredients_bd WHERE recipe_id = :recipeId")
    fun getAllIngredients(recipeId: Int): List<IngredientsEntity>

}