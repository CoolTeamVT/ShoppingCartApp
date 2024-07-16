package com.main.presentation.ui.HomeScreen

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
class HomeScreenViewModel @Inject constructor(
    private val getMealsUsecase: GetMealsUsecase
) : ViewModel() {
    private val _meals =  MutableStateFlow<List<MealsModel>>(emptyList())
    val meals: StateFlow<List<MealsModel>> get() = _meals

    private val _isExpandedStateFlow = MutableStateFlow(listOf(false, false, false, false))
    val isExpandedStateFlow: StateFlow<List<Boolean>> get() = _isExpandedStateFlow

    fun loadMeals(date: String){
        viewModelScope.launch {
            getMealsUsecase.execute(date).collect() {mealsList ->
                _meals.value = mealsList
            }
        }
    }

    fun onEvent(event: HomeScreenEvent) {
        _isExpandedStateFlow.value = _isExpandedStateFlow.value.toMutableList().apply {
            when (event) {
                HomeScreenEvent.BoxExtensionFirstEvent -> {
                    this[0] = !this[0]
                }

                HomeScreenEvent.BoxExtensionSecondEvent -> {
                    this[1] = !this[1]
                }

                HomeScreenEvent.BoxExtensionThirdEvent -> {
                    this[2] = !this[2]
                }

                HomeScreenEvent.BoxExtensionFourthEvent -> {
                    this[3] = !this[3]
                }
            }
        }
    }
}