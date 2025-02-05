package com.lapoushko.effectivetest.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lapoushko.effectivetest.model.AddressItem
import com.lapoushko.effectivetest.model.ExperienceItem
import com.lapoushko.effectivetest.model.OfferItem
import com.lapoushko.effectivetest.model.VacancyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {
    private var _state = MutableMainScreenState()
    val state = _state as MainScreenState

    private class MutableMainScreenState : MainScreenState {
        override var vacancies: List<VacancyItem> by mutableStateOf(
            listOf(
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
        )
        override var offers: List<OfferItem> by mutableStateOf(
            listOf(
                OfferItem(
                    id = "near_vacancies",
                    text = "Вакансии рядом с вами",
                    buttonText = ""
                ),
                OfferItem(
                    id = "level_up_resume",
                    text = "Поднять резюме в поиске",
                    buttonText = "Поднять"
                ),
                OfferItem(
                    id = "temporary_job",
                    text = "Временная работа и подработка",
                    buttonText = ""
                ),
                OfferItem(
                    id = "",
                    text = "Временная работа и подработка",
                    buttonText = ""
                )
            )
        )
    }
}