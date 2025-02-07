package com.lapoushko.domain.repo

import com.lapoushko.domain.entity.vacancy.Vacancy

/**
 * @author Lapoushko
 */
interface VacancyRepository {
    suspend fun getVacancies(): List<Vacancy>
}