package com.lapoushko.data.network.di

import com.lapoushko.data.network.repo.OfferRepositoryImpl
import com.lapoushko.data.network.repo.VacancyRepositoryImpl
import com.lapoushko.domain.repo.OfferRepository
import com.lapoushko.domain.repo.VacancyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Lapoushko
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindVacancyRepository(impl: VacancyRepositoryImpl): VacancyRepository

    @Binds
    abstract fun bindOfferRepository(impl: OfferRepositoryImpl): OfferRepository
}
