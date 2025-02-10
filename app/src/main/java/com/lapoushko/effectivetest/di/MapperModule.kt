package com.lapoushko.effectivetest.di

import com.lapoushko.effectivetest.mapper.OfferMapper
import com.lapoushko.effectivetest.mapper.OfferMapperImpl
import com.lapoushko.effectivetest.mapper.VacancyMapper
import com.lapoushko.effectivetest.mapper.VacancyMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Lapoushko
 */
@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Singleton
    @Provides
    fun provideOfferMapper(): OfferMapper{
        return OfferMapperImpl()
    }

    @Singleton
    @Provides
    fun provideVacancyMapper(): VacancyMapper{
        return VacancyMapperImpl()
    }
}