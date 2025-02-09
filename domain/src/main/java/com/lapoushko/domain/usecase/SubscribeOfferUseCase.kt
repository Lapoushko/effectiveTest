package com.lapoushko.domain.usecase

import com.lapoushko.domain.entity.Offer
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface SubscribeOfferUseCase{
    suspend fun getOffers(): List<Offer>
}

class SubscribeOfferUseCaseImpl @Inject constructor():
    SubscribeOfferUseCase {
    override suspend fun getOffers(): List<Offer> {
        val offers = listOf(
            Offer(
                id = "near_vacancies",
                title = "Вакансии рядом с вами",
                button = "",
                link = "https://hh.ru/"
            ),
            Offer(
                id = "level_up_resume",
                title = "Поднять резюме в поиске",
                button = "Поднять",
                link = "https://hh.ru/"
            ),
            Offer(
                id = "temporary_job",
                title = "Временная работа и подработка",
                button = "",
                link = "https://hh.ru/"
            ),
            Offer(
                id = "",
                title = "Временная работа и подработка",
                button = "",
                link = "https://hh.ru/"
            )
        )
        return offers
//        return repo.getOffers()
    }
}