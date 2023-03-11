package com.bookmark.presentation.domain.module

import com.example.bookmark.data.repository.BookRepositoryImpl
import com.example.bookmark.domain.repository.BookRepository
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
    ) : BookRepository{
        return bookRepositoryImpl
    }
}