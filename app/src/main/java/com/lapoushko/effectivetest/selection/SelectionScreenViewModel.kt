package com.lapoushko.effectivetest.selection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lapoushko.effectivetest.model.AddressItem
import com.lapoushko.effectivetest.model.ExperienceItem
import com.lapoushko.effectivetest.model.VacancyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class SelectionScreenViewModel @Inject constructor() : ViewModel() {
    private var _state = MutableSelectionScreenState()
    val state = _state as SelectionScreenState

    init {
        loadVacancies()
    }

    private fun loadVacancies(){
        _state.vacancies = listOf(
            VacancyItem(
                id = "",
                lookingNumber = "Сейчас просматривает 1 человек",
                title = "UI/UX Designer",
                address = AddressItem(town = "Минск", street = "улица Бирюзова", house = "4/5"),
                company = "Мобирикс",
                experience = ExperienceItem("Опыт от 1 до 3 лет", "1–3 года"),
                publishDate = "Опубликовано 20 февраля",
                salary = "1500-2900 Br"
            ),
            VacancyItem(
                id = "",
                lookingNumber = "Сейчас просматривает 1 человек",
                title = "UI/UX Designer",
                address = AddressItem(town = "Минск", street = "улица Бирюзова", house = "4/5"),
                company = "Мобирикс",
                experience = ExperienceItem("Опыт от 1 до 3 лет", "1–3 года"),
                publishDate = "Опубликовано 20 февраля",
                salary = "1500-2900 Br"
            )
        )
    }

    private class MutableSelectionScreenState: SelectionScreenState{
        override var vacancies: List<VacancyItem> by mutableStateOf(emptyList())
    }
}