package com.lapoushko.effectivetest.navigation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class BottomBarScreenViewModel @Inject constructor(
    useCase: SubscribeVacancyUseCase
) : ViewModel(){
    val countQueries: StateFlow<Int> = useCase.getVacanciesFromDb()
        .map { it.size }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = 0
        )
}