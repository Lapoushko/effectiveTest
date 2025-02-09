package com.lapoushko.domain.usecase

import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.domain.repo.VacancyRepository
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface SubscribeVacancyUseCase {
    suspend fun getVacancies(): List<Vacancy>
}

class SubscribeVacancyUseCaseImpl @Inject constructor(
    private val repo: VacancyRepository
) :
    SubscribeVacancyUseCase {
    override suspend fun getVacancies(): List<Vacancy> {
        return repo.getVacancies()
    }
}