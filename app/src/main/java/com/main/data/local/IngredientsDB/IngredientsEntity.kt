package com.main.data.local.IngredientsDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.main.data.local.FridgeInventoryDB.FridgeInventoryEntity
import com.main.data.local.RecipesDB.RecipeEntity
import com.main.data.local.ShoppingListsDB.ShoppingListEntity

@Entity(
    tableName = "ingredients_bd",
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ShoppingListEntity::class,
            parentColumns = ["id"],
            childColumns = ["shoppingList_id"],
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
    @ColumnInfo("quantity") val quantity: Double,
    @ColumnInfo("measure") val measure: String,
    @ColumnInfo("recipe_id")val recipeId: Int?,
    @ColumnInfo("shoppingList_id")val shoppingListId: Int?,
    @ColumnInfo("fridgeInventory_id")val fridgeInventoryId: Int?
)