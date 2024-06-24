package com.main.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.main.data.local.FridgeInventoryDB.FridgeInventoryDao
import com.main.data.local.FridgeInventoryDB.FridgeInventoryEntity
import com.main.data.local.IngredientsDB.IngredientsDao
import com.main.data.local.IngredientsDB.IngredientsEntity
import com.main.data.local.RecipesDB.RecipeDao
import com.main.data.local.RecipesDB.RecipeEntity
import com.main.data.local.ShoppingListsDB.ShoppingListDao
import com.main.data.local.ShoppingListsDB.ShoppingListEntity

@Database(
    entities = [RecipeEntity::class, ShoppingListEntity::class, FridgeInventoryEntity::class, IngredientsEntity::class],
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

