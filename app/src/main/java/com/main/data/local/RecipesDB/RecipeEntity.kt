package com.main.data.local.RecipesDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (
    tableName = "recipes_db"
)
data class RecipeEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "grams") val grams: Double?,
    @ColumnInfo(name = "image") val imageUrl: String?
)