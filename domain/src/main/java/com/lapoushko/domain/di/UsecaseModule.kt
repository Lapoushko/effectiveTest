package com.lapoushko.domain.di

import com.lapoushko.domain.repo.OfferRepository
import com.lapoushko.domain.repo.VacancyRepository
import com.lapoushko.domain.usecase.SubscribeOfferUseCase
import com.lapoushko.domain.usecase.SubscribeOfferUseCaseImpl
import com.lapoushko.domain.usecase.SubscribeVacancyUseCase
import com.lapoushko.domain.usecase.SubscribeVacancyUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author Lapoushko
 */
@Module
@InstallIn(ViewModelComponent::class)
object UsecaseModule {
   
    @Provides
    fun provideSubscribeVacancyUseCase(
        repo: VacancyRepository
    ) : SubscribeVacancyUseCase {
        return SubscribeVacancyUseCaseImpl(repo)
    }

    @Provides
    fun provideSubscribeOfferUseCase(
        repo: OfferRepository
    ) : SubscribeOfferUseCase {
        return SubscribeOfferUseCaseImpl(repo)
    }
}