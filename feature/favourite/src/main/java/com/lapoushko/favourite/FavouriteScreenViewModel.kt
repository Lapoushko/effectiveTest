package com.lapoushko.favourite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import com.lapoushko.feature.mapper.VacancyMapper
import com.lapoushko.feature.model.VacancyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class FavouriteScreenViewModel @Inject constructor(
    private val vacancyUseCase: SubscribeVacancyUseCase,
    private val vacancyMapper: VacancyMapper
) :  ViewModel(){
    private var _state = MutableFavouriteScreenState()
    val state = _state as FavouriteScreenState

    init{
        loadVacancies()
    }

    private fun loadVacancies(){
        vacancyUseCase.getVacanciesFromDb().onEach{ vacancy ->
            val vacancies = vacancy.map { vacancyMapper.toUi(it) }
            _state.vacancies = vacancies
        }.launchIn(viewModelScope)
    }

    fun unsaveVacancy(vacancy: VacancyItem){
        viewModelScope.launch {
            vacancyUseCase.unsaveVacancy(vacancyMapper.toDomain(vacancy.copy(isFavourite = false)))
            _state.vacancies = _state.vacancies.filterNot { it == vacancy }
        }
    }

    private class MutableFavouriteScreenState: FavouriteScreenState {
        override var vacancies: List<VacancyItem> by mutableStateOf(emptyList())
    }
}