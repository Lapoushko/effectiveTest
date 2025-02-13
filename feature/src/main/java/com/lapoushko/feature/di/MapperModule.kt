package com.lapoushko.feature.di

import com.lapoushko.feature.mapper.OfferMapper
import com.lapoushko.feature.mapper.OfferMapperImpl
import com.lapoushko.feature.mapper.VacancyMapper
import com.lapoushko.feature.mapper.VacancyMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author Lapoushko
 */
@Module
@InstallIn(ViewModelComponent::class)
object MapperModule {
    @Provides
    fun provideOfferMapper(): OfferMapper {
        return OfferMapperImpl()
    }

    @Provides
    fun provideVacancyMapper(): VacancyMapper {
        return VacancyMapperImpl()
    }
}