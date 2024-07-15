package com.main.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.domain.models.MealsModel
import com.main.domain.usecases.GetUsecases.GetMealsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUsecase: GetMealsUsecase
) : ViewModel() {
    private val _meals =  MutableStateFlow<List<MealsModel>>(emptyList())
    val meals: StateFlow<List<MealsModel>> get() = _meals

    private val _isExpandedStateFlow = MutableStateFlow(false)
    val isExpandedStateFlow: StateFlow<Boolean> get() = _isExpandedStateFlow

    fun loadMeals(date: String){
        viewModelScope.launch {
            getMealsUsecase.execute(date).collect() {mealsList ->
                _meals.value = mealsList
            }
        }
    }

    fun toggleExpansion() {
        _isExpandedStateFlow.value = !_isExpandedStateFlow.value
    }
}