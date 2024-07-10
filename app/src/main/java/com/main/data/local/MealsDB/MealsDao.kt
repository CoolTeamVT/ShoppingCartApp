package com.main.data.local.MealsDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MealsDao {

    @Insert(entity = MealsEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(meal: MealsEntity)

    @Query("SELECT * FROM meals_db WHERE date = :date")
    fun getMealOnDate(date: String): Flow<List<MealsEntity>>
}