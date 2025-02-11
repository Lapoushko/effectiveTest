package com.lapoushko.data.repo

import com.lapoushko.data.mapper.VacancyDbMapper
import com.lapoushko.data.mapper.VacancyResponseMapper
import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.domain.repo.VacancyRepository
import com.lapoushko.network.util.JsonDownloader
import com.lapoushko.storage.dao.VacancyDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Lapoushko
 */
class VacancyRepositoryImpl @Inject constructor(
    private val responseMapper: VacancyResponseMapper,
    private val jsonDownloader: JsonDownloader,
    private val dbMapper: VacancyDbMapper,
    private val dao: VacancyDao
) : VacancyRepository {
    override fun getVacancies(): Flow<List<Vacancy>> = flow {
        runCatching {
            jsonDownloader.getResponse().collect { dataResponse ->
                val vacancies = dataResponse?.vacancies?.mapNotNull { vacancy ->
                    val vacFromDao = dao.getVacancy(vacancy?.id ?: "")
                    if (vacFromDao == null && vacancy?.isFavorite == true) {
                        saveVacancy(responseMapper.toDomain(vacancy))
                    }
                    vacancy?.id?.let { id ->
                        dao.getVacancy(id)?.let(dbMapper::toDomain) ?: responseMapper.toDomain(vacancy)
                    }
                } ?: emptyList()
                emit(vacancies)
            }
        }.onFailure {
            emit(emptyList())
        }
    }

    override suspend fun saveVacancy(vacancy: Vacancy) {
        withContext(Dispatchers.IO) {
            dao.insertVacancy(dbMapper.toDb(vacancy))
        }
    }

    override fun getVacanciesFromDb(): Flow<List<Vacancy>> {
        return dao.getVacancies()?.map { vacancies ->
            vacancies.map(dbMapper::toDomain)
        } ?: flowOf(emptyList())
    }


    override suspend fun unsaveVacancy(vacancy: Vacancy) {
        withContext(Dispatchers.IO) {
            dao.deleteVacancy(vacancy.id)
        }
    }
}