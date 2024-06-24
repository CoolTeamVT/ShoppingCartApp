package com.main.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.main.data.local.FridgeInventory.FridgeInventoryDao
import com.main.data.local.FridgeInventory.FridgeInventoryEntity
import com.main.data.local.IngredientsDB.IngredientsDao
import com.main.data.local.IngredientsDB.IngredientsEntity
import com.main.data.local.RecipesDB.RecipeDao
import com.main.data.local.RecipesDB.RecipeDatabaseEntity
import com.main.data.local.ShoppingLists.ShoppingListDao
import com.main.data.local.ShoppingLists.ShoppingListEntity

@Database(
    entities = [RecipeDatabaseEntity::class, ShoppingListEntity::class, FridgeInventoryEntity::class, IngredientsEntity::class],
    version = 1
)abstract class AppDatabase: RoomDatabase() {
    abstract val recipeDao: RecipeDao
    abstract val shoppingListDao: ShoppingListDao
    abstract val fridgeInventoryDao: FridgeInventoryDao
    abstract val ingredientsDao: IngredientsDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        private const val DB_NAME = "ShoppingCart_DB"

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                )
                .build()
                .also { INSTANCE = it }
            }
        }
    }

