package com.main.data.local.MealsDB

import androidx.compose.foundation.layout.FlowRow
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.main.data.local.RecipesDB.RecipeEntity

@Entity(
    tableName = "meals_db",
    foreignKeys = [ ForeignKey(
        entity = RecipeEntity::class,
        parentColumns = ["id"],
        childColumns = ["recipe_id"],
        onDelete = ForeignKey.CASCADE
    ) ]
)
data class MealsEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "recipe_id") val recipeId: Int
)
