package com.lapoushko.data.di

import com.lapoushko.data.mapper.OfferResponseMapper
import com.lapoushko.data.mapper.OfferResponseMapperImpl
import com.lapoushko.data.mapper.VacancyDbMapper
import com.lapoushko.data.mapper.VacancyDbMapperImpl
import com.lapoushko.data.mapper.VacancyResponseMapper
import com.lapoushko.data.mapper.VacancyResponseMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Lapoushko
 */
@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideOfferResponseMapper(): OfferResponseMapper {
        return OfferResponseMapperImpl()
    }

    @Provides
    fun provideVacancyResponseMapper(): VacancyResponseMapper {
        return VacancyResponseMapperImpl()
    }

    @Provides
    fun provideVacancyDbMapper(): VacancyDbMapper{
        return VacancyDbMapperImpl()
    }
}