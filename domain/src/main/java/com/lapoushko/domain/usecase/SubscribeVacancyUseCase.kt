package com.lapoushko.domain.usecase

import com.lapoushko.domain.entity.vacancy.Address
import com.lapoushko.domain.entity.vacancy.Experience
import com.lapoushko.domain.entity.vacancy.Vacancy
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface SubscribeVacancyUseCase {
    suspend fun getVacancies(): List<Vacancy>
}

class SubscribeVacancyUseCaseImpl @Inject constructor() :
    SubscribeVacancyUseCase {
    override suspend fun getVacancies(): List<Vacancy> {
        val vacancies = listOf(
            Vacancy(
                id = "",
                lookingNumber = 1,
                title = "UI/UX Designer",
                address = Address(town = "Минск", street = "улица Бирюзова", house = "4/5"),
                company = "Мобирикс",
                experience = Experience("Опыт от 1 до 3 лет", "1–3 года"),
                publishDate = "2025-03-07",
                salary = "1500-2900 Br"
            ),
            Vacancy(
                id = "",
                lookingNumber = 0,
                title = "UI/UX Designer",
                address = Address(town = "Минск", street = "улица Бирюзова", house = "4/5"),
                company = "Мобирикс",
                experience = Experience("Опыт от 1 до 3 лет", "1–3 года"),
                publishDate = "2025-03-07",
                salary = "1500-2900 Br"
            ),
            Vacancy(
                id = "",
                lookingNumber = 1,
                title = "UI/UX Designer",
                address = Address(town = "Минск", street = "улица Бирюзова", house = "4/5"),
                company = "Мобирикс",
                experience = Experience("Опыт от 1 до 3 лет", "1–3 года"),
                publishDate = "2025-03-07",
                salary = ""
            ),
            Vacancy(
                id = "",
                lookingNumber = 1,
                title = "UI/UX Designer",
                address = Address(town = "Минск", street = "улица Бирюзова", house = "4/5"),
                company = "Мобирикс",
                experience = Experience("Опыт от 1 до 3 лет", "1–3 года"),
                publishDate = "2025-03-07",
                salary = "1500-2900 Br"
            ),
        )
        return vacancies
//        return repo.getVacancies()
    }
}