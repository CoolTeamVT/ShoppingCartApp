package com.main.domain.usecases.GetFromDBUsecases

import com.main.domain.models.IngredientModel

interface GetFromRecipeDBUsecase{
    suspend fun execute (params: None) : List<IngredientModel>
}

