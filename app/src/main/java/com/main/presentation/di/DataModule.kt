package com.main.presentation.di

import com.main.data.repositories.FridgeInventoryRepositoryImpl
import com.main.data.repositories.IngredientsRepositoryImpl
import com.main.data.repositories.RecipeRepositoryImpl
import com.main.data.repositories.ShoppingListsRepositoryImpl
import com.main.domain.repositories.FridgeInventoryRepository
import com.main.domain.repositories.IngredientsRepository
import com.main.domain.repositories.RecipesRepository
import com.main.domain.repositories.ShoppingListsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindFridgeInventoryRepository(
        fridgeInventoryRepositoryImpl: FridgeInventoryRepositoryImpl): FridgeInventoryRepository

    @Binds
    abstract fun bindIngredientsRepository(
        ingredientsRepositoryImpl: IngredientsRepositoryImpl): IngredientsRepository

    @Binds
    abstract fun bindRecipeRepository(
        recipeRepositoryImpl: RecipeRepositoryImpl): RecipesRepository

    @Binds
    abstract fun bindShoppingListsRepository(
        shoppingListsRepositoryImpl: ShoppingListsRepositoryImpl): ShoppingListsRepository


}