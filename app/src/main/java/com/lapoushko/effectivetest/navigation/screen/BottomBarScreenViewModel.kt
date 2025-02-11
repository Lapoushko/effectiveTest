package com.lapoushko.effectivetest.navigation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class BottomBarScreenViewModel @Inject constructor(
    private val useCase: SubscribeVacancyUseCase
) : ViewModel() {

    private val _countQueries = MutableStateFlow(0)
    val countQueries = _countQueries.asStateFlow()

    init {
        viewModelScope.launch {
            useCase.getVacanciesFromDb().collect { vacancies ->
                _countQueries.value = vacancies.size
            }
        }
    }
}