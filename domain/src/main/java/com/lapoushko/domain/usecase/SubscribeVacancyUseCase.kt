package com.lapoushko.domain.usecase

import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.domain.repo.VacancyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface SubscribeVacancyUseCase {
    fun getVacancies(): Flow<List<Vacancy>>

    fun getVacanciesFromDb(): Flow<List<Vacancy>>

    suspend fun saveVacancy(vacancy: Vacancy)

    suspend fun unsaveVacancy(vacancy: Vacancy)
}

class SubscribeVacancyUseCaseImpl @Inject constructor(
    private val repo: VacancyRepository
) :
    SubscribeVacancyUseCase {
    override fun getVacancies(): Flow<List<Vacancy>> {
        return repo.getVacancies()
    }

    override fun getVacanciesFromDb(): Flow<List<Vacancy>> {
        return repo.getVacanciesFromDb()
    }

    override suspend fun saveVacancy(vacancy: Vacancy) {
        repo.saveVacancy(vacancy)
    }

    override suspend fun unsaveVacancy(vacancy: Vacancy) {
        repo.unsaveVacancy(vacancy)
    }
}