package com.lapoushko.data.di

import android.content.Context
import com.lapoushko.data.service.DataServiceImpl
import com.lapoushko.network.service.DataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * @author Lapoushko
 */
@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun provideDataService(
        @ApplicationContext context: Context,
    ): DataService{
        return DataServiceImpl(context)
    }
}