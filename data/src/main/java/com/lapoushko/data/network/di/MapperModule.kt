package com.lapoushko.data.network.di

import com.lapoushko.data.network.mapper.OfferResponseMapper
import com.lapoushko.data.network.mapper.OfferResponseMapperImpl
import com.lapoushko.data.network.mapper.VacancyResponseMapper
import com.lapoushko.data.network.mapper.VacancyResponseMapperImpl
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
    fun provideOfferResponseMapper(): OfferResponseMapper{
        return OfferResponseMapperImpl()
    }

    @Provides
    fun provideVacancyResponseMapper(): VacancyResponseMapper {
        return VacancyResponseMapperImpl()
    }
}