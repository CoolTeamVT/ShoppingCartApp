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
class RecipeDetailViewModel @Inject constructor(
    private val getFromRecipeDBUsecase: GetFromRecipeDBUsecase
) : ViewModel() {

    private val _recipe = MutableStateFlow<RecipeModel?>(null)
    val recipe: StateFlow<RecipeModel?> get() = _recipe

    fun loadRecipe(recipeId: Int) {
        viewModelScope.launch {
            getFromRecipeDBUsecase.execute(None).collect { recipesList ->
                _recipe.value = recipesList.find { it.id == recipeId }
            }
        }
    }
}
