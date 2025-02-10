package com.lapoushko.domain.entity.vacancy

/**
 * @author Lapoushko
 */
class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: Address,
    val company: String,
    val experience: Experience,
    val publishDate: String,
    val salary: String,
    val isFavourite: Boolean
)