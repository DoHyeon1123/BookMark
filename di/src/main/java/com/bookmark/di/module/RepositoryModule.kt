package com.bookmark.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    /*@Singleton
    @Provides
    fun provideBookRepository(
        bookRepositoryImpl: BookRepositoryImpl
    ) : BookRepository{
        return bookRepositoryImpl
    }*/
}