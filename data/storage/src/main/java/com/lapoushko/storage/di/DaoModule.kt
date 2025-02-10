package com.lapoushko.storage.di

import android.content.Context
import androidx.room.Room
import com.lapoushko.storage.dao.VacancyDao
import com.lapoushko.storage.dao.VacancyDatabase
import com.lapoushko.storage.util.ConstantsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Lapoushko
 */
@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideVacancyDatabase(@ApplicationContext context: Context) : VacancyDatabase =
        Room.databaseBuilder(
            context,
            VacancyDatabase::class.java,
            ConstantsDatabase.NAME_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideVacancyDao(appDatabase: VacancyDatabase): VacancyDao{
        return appDatabase.VacancyDao()
    }
}