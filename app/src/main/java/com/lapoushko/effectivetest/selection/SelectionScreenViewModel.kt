package com.lapoushko.effectivetest.selection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import com.lapoushko.effectivetest.mapper.VacancyMapper
import com.lapoushko.effectivetest.model.VacancyItem
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

    private fun loadVacancies(){
        viewModelScope.launch {
            _state.vacancies = vacancyUseCase.getVacancies().map { vacancyMapper.toUi(it) }
        }
    }

    private class MutableSelectionScreenState: SelectionScreenState{
        override var vacancies: List<VacancyItem> by mutableStateOf(emptyList())
    }
}