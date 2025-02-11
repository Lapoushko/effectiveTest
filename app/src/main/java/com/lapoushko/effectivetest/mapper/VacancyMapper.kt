package com.lapoushko.effectivetest.mapper

import com.lapoushko.domain.entity.vacancy.Address
import com.lapoushko.domain.entity.vacancy.Experience
import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.effectivetest.model.AddressItem
import com.lapoushko.effectivetest.model.ExperienceItem
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.util.getDeclination
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface VacancyMapper {
    fun toUi(vacancy: Vacancy): VacancyItem

    fun toDomain(vacancyItem: VacancyItem): Vacancy
}

class VacancyMapperImpl @Inject constructor() : VacancyMapper {
    override fun toUi(vacancy: Vacancy): VacancyItem {
        vacancy.apply {
            return VacancyItem(
                id = id,
                lookingNumber = if (lookingNumber != 0) {
                    "Сейчас просматривает $lookingNumber ${
                        getDeclination(
                            lookingNumber,
                            "человек"
                        )
                    }"
                } else "",
                title = title,
                address = AddressItem(
                    town = address.town,
                    street = address.street,
                    house = address.house
                ),
                company = company,
                experience = ExperienceItem(
                    previewText = experience.previewText,
                    text = experience.text
                ),
                publishDate = publishDate,
                salary = salary,
                isFavourite = isFavourite
            )
        }
    }

    override fun toDomain(vacancyItem: VacancyItem): Vacancy {
        vacancyItem.apply {
            return Vacancy(
                id = id,
                lookingNumber = if (lookingNumber.isEmpty()) 0 else lookingNumber.split(" ")[2].toInt(),
                title = title,
                address = Address(
                    town = address.town,
                    street = address.street,
                    house = address.house
                ),
                company = company,
                experience = Experience(
                    previewText = experience.previewText,
                    text = experience.text
                ),
                publishDate = publishDate,
                salary = salary,
                isFavourite = isFavourite
            )
        }
    }
}