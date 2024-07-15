package com.main.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.domain.models.RecipeModel
import com.main.domain.usecases.GetUsecases.GetFromRecipeDBUsecase
import com.main.domain.usecases.GetUsecases.None
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val getFromRecipeDBUsecase: GetFromRecipeDBUsecase
): ViewModel() {
    private val _recipes = MutableStateFlow<List<RecipeModel>>(emptyList())
    val recipes: StateFlow<List<RecipeModel>> get() = _recipes

    fun loadRecipes(){
        viewModelScope.launch{
            getFromRecipeDBUsecase.execute(None).collect{ recipesList ->
                _recipes.value = recipesList
            }
        }
    }

    fun getRecipeById(recipeId: Int): RecipeModel?{
        return _recipes.value.find { it.id == recipeId }
    }
}