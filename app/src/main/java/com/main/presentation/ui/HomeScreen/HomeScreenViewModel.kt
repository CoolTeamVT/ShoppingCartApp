package com.main.presentation.ui.HomeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.domain.models.MealsModel
import com.main.domain.usecases.GetUsecases.GetMealsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getMealsUsecase: GetMealsUsecase
) : ViewModel() {
    private val _meals =  MutableStateFlow<List<MealsModel>>(emptyList())
    val meals: StateFlow<List<MealsModel>> get() = _meals

    private val _isExpandedStateFlow = MutableStateFlow(listOf(false, false, false, false))
    val isExpandedStateFlow: StateFlow<List<Boolean>> get() = _isExpandedStateFlow

    private val _date = MutableStateFlow(LocalDate.now().toString())
    val date: StateFlow<String> = _date

    private val _dateUi = MutableStateFlow(_date.value)
    val dateUi: StateFlow<String> = _dateUi

    private val _isDatePickerOpened = MutableStateFlow(false)
    val isDatePickerOpened : StateFlow<Boolean> = _isDatePickerOpened

    init {
        loadMeals(_date.value)
        updateDateForUi()
    }

    private fun updateDateForUi() {
        val dateString = _date.value

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val localDate = LocalDate.parse(dateString, formatter)

        val today = LocalDate.now()
        val yesterday = today.minusDays(1)
        val tomorrow = today.plusDays(1)

        _dateUi.value = when {
            _date.value.equals(today.toString()) -> "Today"
            _date.value.equals(yesterday.toString()) -> "Yesterday"
            _date.value.equals(tomorrow.toString()) -> "Tomorrow"
            else -> localDate.format(DateTimeFormatter.ofPattern("d MMMM"))
        }
    }

    fun loadMeals(date: String){
        viewModelScope.launch {
            getMealsUsecase.execute(date).collect {mealsList ->
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

                HomeScreenEvent.onDateClickedEvent -> {
                    _isDatePickerOpened.value = !_isDatePickerOpened.value
                }

            }
        }
    }

    fun updateDate(newDate: String) {
        _date.value = newDate
        updateDateForUi()
        loadMeals(newDate)

    }
}