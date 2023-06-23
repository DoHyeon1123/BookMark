package com.bookmark.di

import com.bookmark.data.repository.BookRepositoryImpl
import com.bookmark.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideBookRepository(
        bookRepositoryImpl: BookRepositoryImpl
    ) : BookRepository {
        return bookRepositoryImpl
    }
}