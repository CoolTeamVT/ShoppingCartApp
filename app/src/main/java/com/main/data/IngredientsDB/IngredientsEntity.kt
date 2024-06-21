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
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ShoppingListEntity::class,
            parentColumns = ["id"],
            childColumns = ["shoppinglist_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = FridgeInventoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["fridgeInventory_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class IngredientsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("ingredient_name")val name: String,
    @ColumnInfo("grams")val grams: Double,
    val recipe_id: Int?,
    val shoppinglist_id: Int?,
    val fridgeInventory_id: Int?
)