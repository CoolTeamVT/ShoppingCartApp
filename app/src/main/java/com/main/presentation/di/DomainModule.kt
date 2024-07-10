package com.main.presentation.di

import com.main.domain.usecases.GetUsecases.GetFromApiUsecase
import com.main.domain.usecases.GetUsecases.GetFromApiUsecaseImpl
import com.main.domain.usecases.GetUsecases.GetFromFridgeInventoryDBUsecase
import com.main.domain.usecases.GetUsecases.GetFromFridgeInventoryDBUsecaseImpl
import com.main.domain.usecases.GetUsecases.GetFromIngredientDBUsecase
import com.main.domain.usecases.GetUsecases.GetFromIngredientDBUsecaseImpl
import com.main.domain.usecases.GetUsecases.GetFromRecipeDBUsecase
import com.main.domain.usecases.GetUsecases.GetFromRecipeDBUsecaseImpl
import com.main.domain.usecases.GetUsecases.GetFromShoppingListDBUsecase
import com.main.domain.usecases.GetUsecases.GetFromShoppingListDBUsecaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindGetFromFridgeInventoryDBUsecase(getFromFridgeInventoryDBUsecaseImpl:
                                                       GetFromFridgeInventoryDBUsecaseImpl) :
            GetFromFridgeInventoryDBUsecase

    @Binds
    abstract fun bindGetFromIngredientDBUsecase(getFromIngredientDBUsecaseImpl:
                                                    GetFromIngredientDBUsecaseImpl) :
            GetFromIngredientDBUsecase
    @Binds
    abstract fun bindGetFromRecipeDBUsecase(getFromRecipeDBUsecaseImpl:
                                                GetFromRecipeDBUsecaseImpl) :
            GetFromRecipeDBUsecase
    @Binds
    abstract fun bindGetFromShoppingListDBUsecase(getFromShoppingListDBUsecaseImpl:
                                                      GetFromShoppingListDBUsecaseImpl) :
            GetFromShoppingListDBUsecase

    @Binds
    abstract fun bindGetFromApiUsecase(getFromApiUsecaseImpl: GetFromApiUsecaseImpl):
            GetFromApiUsecase
}