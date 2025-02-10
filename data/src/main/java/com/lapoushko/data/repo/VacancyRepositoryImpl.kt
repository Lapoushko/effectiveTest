package com.lapoushko.data.repo

import com.lapoushko.data.mapper.VacancyDbMapper
import com.lapoushko.data.mapper.VacancyResponseMapper
import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.domain.repo.VacancyRepository
import com.lapoushko.network.service.DataService
import com.lapoushko.storage.dao.VacancyDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Lapoushko
 */
class VacancyRepositoryImpl @Inject constructor(
    private val responseMapper: VacancyResponseMapper,
    private val dbMapper: VacancyDbMapper,
    private val dataService: DataService,
    private val dao: VacancyDao
) : VacancyRepository {
    override fun getVacancies(): Flow<List<Vacancy>> = flow {
        emit(
            runCatching {
                dataService.getResponse()?.vacancies?.mapNotNull { vacancy ->
                    val vacFromDao = dao.getVacancy(vacancy?.id ?: "")
                    if (vacFromDao == null && vacancy?.isFavorite!!){
                        saveVacancy(responseMapper.toDomain(vacancy))
                    }
                    vacancy?.id?.let { id ->
                        dao.getVacancy(id)?.let(dbMapper::toDomain) ?: responseMapper.toDomain(vacancy)
                    }

                } ?: emptyList()
            }.getOrElse {
                emptyList()
            }
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun saveVacancy(vacancy: Vacancy) {
        withContext(Dispatchers.IO) {
            dao.insertVacancy(dbMapper.toDb(vacancy).copy(isFavourite = true))
        }
    }

    override fun getVacanciesFromDb(): Flow<List<Vacancy>> = flow {
        emit(dao.getVacancies()?.map(dbMapper::toDomain) ?: emptyList())
    }.flowOn(Dispatchers.IO)


    override suspend fun unsaveVacancy(vacancy: Vacancy) {
        withContext(Dispatchers.IO){
            dao.deleteVacancy(vacancy.id)
        }
    }
}