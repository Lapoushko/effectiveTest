package com.lapoushko.data.mapper

import com.lapoushko.domain.entity.vacancy.Experience
import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.network.entity.VacancyResponse
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface VacancyResponseMapper {
    fun toDomain(vacancyResponse: VacancyResponse): Vacancy
}

class VacancyResponseMapperImpl @Inject constructor() :
    VacancyResponseMapper {
    override fun toDomain(vacancyResponse: VacancyResponse): Vacancy {
        vacancyResponse.apply {
            return Vacancy(
                id = id ?: "",
                lookingNumber = lookingNumber ?: 0,
                title = title ?: "",
                address = com.lapoushko.domain.entity.vacancy.Address(
                    town = address?.town ?: "",
                    street = address?.street ?: "",
                    house = address?.house ?: ""
                ),
                company = company ?: "",
                experience = Experience(
                    text = experience?.text ?: "",
                    previewText = experience?.previewText ?: ""
                ),
                publishDate = publishedDate ?: "",
                salary = salary?.short ?: "",
                isFavourite = isFavorite ?: false
            )
        }
    }

}