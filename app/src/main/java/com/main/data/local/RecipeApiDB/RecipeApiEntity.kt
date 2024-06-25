package com.main.data.local.RecipeApiDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeApiEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val grams: Double?,
    val imageUrl: String?
)