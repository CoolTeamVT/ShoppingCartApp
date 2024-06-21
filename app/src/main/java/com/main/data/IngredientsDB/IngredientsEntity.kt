package com.main.data.IngredientsDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.main.data.FridgeInventory.FridgeInventoryEntity
import com.main.data.RecipesDB.RecipeDatabaseEntity
import com.main.data.ShoppingLists.ShoppingListEntity

@Entity(
    tableName = "ingredients_bd",
    foreignKeys = [
        ForeignKey(
            entity = RecipeDatabaseEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ShoppingListEntity::class,
            parentColumns = ["id"],
            childColumns = ["shoppingListId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = FridgeInventoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["fridgeInventoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class IngredientsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("ingredient_name")val name: String,
    @ColumnInfo("grams")val grams: Double,
    @ColumnInfo("recipeId")val recipeId: Int?,
    @ColumnInfo("shoppingListId")val shoppingListId: Int?,
    @ColumnInfo("fridgeInventoryId")val fridgeInventoryId: Int?
)