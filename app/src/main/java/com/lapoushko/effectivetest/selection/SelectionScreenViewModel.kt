package com.lapoushko.effectivetest.selection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import com.lapoushko.effectivetest.mapper.VacancyMapper
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.util.StatusLoading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class SelectionScreenViewModel @Inject constructor(
    private val vacancyUseCase: SubscribeVacancyUseCase,
    private val vacancyMapper: VacancyMapper
) : ViewModel() {
    private var _state = MutableSelectionScreenState()
    val state = _state as SelectionScreenState

    init {
        loadVacancies()
    }

    fun loadVacancies() {
        viewModelScope.launch {
            _state.status = StatusLoading.LOADING
            vacancyUseCase.getVacancies().collect{ vacancies ->
                val vacs = vacancies.map { vacancyMapper.toUi(it) }
                _state.vacancies = vacs
                _state.status = StatusLoading.SUCCESS
            }
        }
    }

    fun handleVacancySave(vacancy: VacancyItem) {
        viewModelScope.launch {
            _state.status = StatusLoading.LOADING
            if (vacancy.isFavourite){
                vacancyUseCase.unsaveVacancy(vacancyMapper.toDomain(vacancy))
            } else{
                vacancyUseCase.saveVacancy(vacancyMapper.toDomain(vacancy.copy(isFavourite = true)))
            }
            loadVacancies()
        }
    }

    private class MutableSelectionScreenState: SelectionScreenState{
        override var vacancies: List<VacancyItem> by mutableStateOf(emptyList())
        override var status: StatusLoading by mutableStateOf(StatusLoading.LOADING)
    }
}