package com.main.presentation.ui.RecipeDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.domain.models.RecipeModel
import com.main.domain.usecases.GetUsecases.GetFromRecipeByIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val getFromRecipeByIDUseCase: GetFromRecipeByIDUseCase
): ViewModel() {
    private val _recipe = MutableStateFlow<RecipeModel?>(null)
    val recipe: StateFlow<RecipeModel?> = _recipe

    private fun uploadData(id: Int) {
        viewModelScope.launch {
            getFromRecipeByIDUseCase.execute(id).collect {
                _recipe.value = it
            }
        }
    }

    fun onEvent(event: RecipeDetailScreenEvent) {
        when(event){
            is RecipeDetailScreenEvent.LoadDataEvent -> {
                uploadData(event.id)
            }
        }
    }
}