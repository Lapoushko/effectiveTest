package com.lapoushko.effectivetest.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lapoushko.domain.usecase.SubscribeOfferUseCase
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import com.lapoushko.effectivetest.mapper.OfferMapper
import com.lapoushko.effectivetest.mapper.VacancyMapper
import com.lapoushko.effectivetest.model.OfferItem
import com.lapoushko.effectivetest.model.VacancyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val vacancyUseCase: SubscribeVacancyUseCase,
    private val offerUseCase: SubscribeOfferUseCase,
    private val offerMapper: OfferMapper,
    private val vacancyMapper: VacancyMapper
) : ViewModel() {
    private var _state = MutableMainScreenState()
    val state = _state as MainScreenState

    init {
        loadVacancies()
        loadOffers()
    }

    private fun loadVacancies(){
        viewModelScope.launch {
            _state.vacancies = vacancyUseCase.getVacancies().map { vacancyMapper.toUi(it) }.take(3)
        }
    }

    private fun loadOffers(){
        viewModelScope.launch {
            _state.offers = offerUseCase.getOffers().map { offerMapper.toUi(it) }
        }

    }

    private class MutableMainScreenState : MainScreenState {
        override var vacancies: List<VacancyItem> by mutableStateOf(emptyList())
        override var offers: List<OfferItem> by mutableStateOf(emptyList())
    }
}