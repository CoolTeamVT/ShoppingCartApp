package com.main.data.RecipesDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (
    tableName = "recipes_db"
)
data class RecipeDatabaseEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description : String?,
    @ColumnInfo(name = "grams") val grams: Double?,
    @ColumnInfo(name = "number_of_servings") val servingsNumber: Int?,
    @ColumnInfo(name = "preparation_time") val preparationTime: String?,
    @ColumnInfo(name = "image") val imageUrl: String?
){
    companion object {
        //TODO: fun from(recipeModel: RecipeModel): RecipeDatabaseEntity
        //TODO: fun to(): RecipeModel
    }
}