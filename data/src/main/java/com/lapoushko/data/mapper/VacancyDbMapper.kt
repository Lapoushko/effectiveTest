package com.lapoushko.data.mapper

import com.lapoushko.domain.entity.vacancy.Address
import com.lapoushko.domain.entity.vacancy.Experience
import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.storage.entity.AddressDb
import com.lapoushko.storage.entity.ExperienceDb
import com.lapoushko.storage.entity.VacancyDb
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface VacancyDbMapper {
    fun toDomain(vacancyDb: VacancyDb): Vacancy

    fun toDb(vacancy: Vacancy) : VacancyDb
}

class VacancyDbMapperImpl @Inject constructor() : VacancyDbMapper{
    override fun toDomain(vacancyDb: VacancyDb): Vacancy {
        vacancyDb.apply {
            return Vacancy(
                id = idString ?: "",
                lookingNumber = lookingNumber ?: 0,
                title = title ?: "",
                address = Address(
                    town = address?.town ?: "",
                    street = address?.street ?: "",
                    house = address?.house ?: ""
                ),
                company = company ?: "",
                experience = Experience(previewText = experience?.previewText ?: "", text = experience?.text ?: ""),
                publishDate = publishDate ?: "",
                salary = salary ?: "",
                isFavourite = isFavourite ?: false,
            )
        }
    }

    override fun toDb(vacancy: Vacancy): VacancyDb {
        vacancy.apply {
            return VacancyDb(
                idString = id,
                lookingNumber = lookingNumber,
                title = title,
                address = AddressDb(town = address.town, street = address.street, house = address.house),
                company = company,
                experience = ExperienceDb(previewText = experience.previewText, text = experience.text),
                publishDate = publishDate,
                salary = salary,
                isFavourite = isFavourite,
            )
        }
    }

}