package com.main.presentation.di

import android.app.Application
import com.main.data.local.AppDatabase
import com.main.data.local.FridgeInventoryDB.FridgeInventoryDao
import com.main.data.local.IngredientsDB.IngredientsDao
import com.main.data.local.RecipesDB.RecipeDao
import com.main.data.local.ShoppingListsDB.ShoppingListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Application) : AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideRecipeDao(appDatabase: AppDatabase) : RecipeDao {
        return appDatabase.recipeDao()
    }
    @Provides
    @Singleton
    fun provideShoppingListDao(appDatabase: AppDatabase) : ShoppingListDao {
        return appDatabase.shoppingListDao()
    }
    @Provides
    @Singleton
    fun provideFridgeInventoryDao(appDatabase: AppDatabase) : FridgeInventoryDao {
        return appDatabase.fridgeInventoryDao()
    }
    @Provides
    @Singleton
    fun provideIngredientsDao(appDatabase: AppDatabase) : IngredientsDao {
        return appDatabase.ingredientsDao()
    }

}