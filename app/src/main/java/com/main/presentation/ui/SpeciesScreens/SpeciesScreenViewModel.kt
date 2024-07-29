package com.main.presentation.ui.SpeciesScreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.main.data.Mappers.toRecipeModelWithIngredients
import com.main.data.Mappers.toUiSpecie
import com.main.domain.usecases.GetUsecases.GetFromApiUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SpeciesScreenViewModel @Inject constructor(
    private val repository: GetFromApiUsecase

): ViewModel(){

    private val _query = MutableStateFlow<String?>("q")
    val query: StateFlow<String?> get() = _query

    val species: Flow<PagingData<Specie>> = _query.flatMapLatest { query ->
        repository.execute(query).flow.map { it.map {it.toRecipeModelWithIngredients().toUiSpecie()} }
            .cachedIn(viewModelScope)
    }

    fun setQuery(newQuery: String) {
        _query.value = newQuery
    }
}