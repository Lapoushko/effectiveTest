package com.lapoushko.network.di

import android.content.Context
import com.lapoushko.network.service.DataService
import com.lapoushko.network.util.JsonDownloader
import com.lapoushko.network.util.JsonDownloaderImpl
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
object JsonModule {

    @Provides
    fun provideJsonDownloader(
        dataService: DataService,
        @ApplicationContext context: Context
    ) : JsonDownloader{
        return JsonDownloaderImpl(dataService, context)
    }
}