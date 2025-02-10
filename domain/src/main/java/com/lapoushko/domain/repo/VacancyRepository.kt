package com.lapoushko.domain.repo

import com.lapoushko.domain.entity.vacancy.Vacancy
import kotlinx.coroutines.flow.Flow

/**
 * @author Lapoushko
 */
interface VacancyRepository {
    fun getVacancies(): Flow<List<Vacancy>>

    fun getVacanciesFromDb(): Flow<List<Vacancy>>

    suspend fun saveVacancy(vacancy: Vacancy)

    suspend fun unsaveVacancy(vacancy: Vacancy)
}