package com.lapoushko.effectivetest.main

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lapoushko.effectivetest.model.AddressItem
import com.lapoushko.effectivetest.model.ExperienceItem
import com.lapoushko.effectivetest.model.OfferItem
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.util.formatDate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Lapoushko
 */
@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {
    private var _state = MutableMainScreenState()
    val state = _state as MainScreenState

    init {
        loadVacancies()
        loadOffers()
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
                publishDate = "Опубликовано ${formatDate("2025-03-07")}",
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
        ).take(3)
    }

    private fun loadOffers(){
        _state.offers = listOf(
            OfferItem(
                id = "near_vacancies",
                title = "Вакансии рядом с вами",
                button = "",
                link = Uri.parse("https://hh.ru/")
            ),
            OfferItem(
                id = "level_up_resume",
                title = "Поднять резюме в поиске",
                button = "Поднять",
                link = Uri.parse("https://hh.ru/")
            ),
            OfferItem(
                id = "temporary_job",
                title = "Временная работа и подработка",
                button = "",
                link = Uri.parse("https://hh.ru/")
            ),
            OfferItem(
                id = "",
                title = "Временная работа и подработка",
                button = "",
                link = Uri.parse("https://hh.ru/")
            )
        )
    }

    private class MutableMainScreenState : MainScreenState {
        override var vacancies: List<VacancyItem> by mutableStateOf(emptyList())
        override var offers: List<OfferItem> by mutableStateOf(emptyList())
    }
}