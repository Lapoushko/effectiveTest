package com.lapoushko.effectivetest.model

/**
 * @author Lapoushko
 */
class VacancyItem(
    val id: String,
    val lookingNumber: String,
    val title: String,
    val address: AddressItem,
    val company: String,
    val experience: ExperienceItem,
    val publishDate: String,
    val salary: String,
)