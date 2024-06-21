package com.main.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.main.data.FridgeInventory.FridgeInventoryDao
import com.main.data.FridgeInventory.FridgeInventoryEntity
import com.main.data.IngredientsDB.IngredientsDao
import com.main.data.IngredientsDB.IngredientsEntity
import com.main.data.RecipesDB.RecipeDao
import com.main.data.RecipesDB.RecipeDatabaseEntity
import com.main.data.ShoppingLists.ShoppingListDao
import com.main.data.ShoppingLists.ShoppingListEntity

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

