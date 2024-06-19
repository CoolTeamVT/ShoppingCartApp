package com.main.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.main.data.RecipesDB.RecipeDao
import com.main.data.RecipesDB.RecipeDatabaseEntity

@Database(
    entities = [RecipeDatabaseEntity::class],
    version = 1
)abstract class AppDatabase: RoomDatabase() {
    abstract val recipeDao: RecipeDao

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


}
