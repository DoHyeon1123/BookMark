package com.bookmark.di

import com.bookmark.data.datasource.AuthDataSource
import com.bookmark.data.datasource.BookDataSource
import com.bookmark.data.db.cache.BookCache
import com.bookmark.data.network.remote.BookRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Singleton
    @Provides
    fun provideBookDataSource(remote : BookRemote, cache :BookCache) : BookDataSource {
        return BookDataSource(remote, cache)
    }

    @Singleton
    @Provides
    fun provideAuthDataSource() : AuthDataSource {
        return AuthDataSource()
    }
}