package com.lapoushko.domain.di

import com.lapoushko.domain.usecase.SubscribeOfferUseCase
import com.lapoushko.domain.usecase.SubscribeOfferUseCaseImpl
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import com.lapoushko.domain.usecase.SubscribeVacancyUseCaseImpl
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
object UsecaseModule {
    @Singleton
    @Provides
    fun provideSubscribeVacancyUseCase() : SubscribeVacancyUseCase {
        return SubscribeVacancyUseCaseImpl()
    }

    @Singleton
    @Provides
    fun provideSubscribeOfferUseCase() : SubscribeOfferUseCase {
        return SubscribeOfferUseCaseImpl()
    }
}