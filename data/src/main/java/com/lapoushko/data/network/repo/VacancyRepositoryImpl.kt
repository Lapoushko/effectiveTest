package com.lapoushko.data.network.repo

import android.content.Context
import com.lapoushko.data.network.entity.DataResponse
import com.lapoushko.data.network.entity.VacancyResponse
import com.lapoushko.data.network.mapper.VacancyResponseMapper
import com.lapoushko.data.network.util.loadJSONFromAssets
import com.lapoushko.domain.entity.vacancy.Vacancy
import com.lapoushko.domain.repo.VacancyRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Lapoushko
 */
class VacancyRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val mapper: VacancyResponseMapper
) : VacancyRepository {
    override suspend fun getVacancies(): List<Vacancy> {
        return withContext(Dispatchers.IO) {
            try {
                val json = loadJSONFromAssets(context, "mockdata.json")

                val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                val jsonAdapter = moshi.adapter(DataResponse::class.java)

                jsonAdapter.fromJson(json ?: "")?.vacancies?.map {
                    mapper.toDomain(
                        it ?: VacancyResponse()
                    )
                } ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}