package com.main.data.IngredientsDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IngredientsDao {
    @Insert
    fun insert(ingredient: IngredientsEntity)

    @Query("SELECT * FROM ingredients_bd")
    fun getAllIngredients(): List<IngredientsEntity>
}