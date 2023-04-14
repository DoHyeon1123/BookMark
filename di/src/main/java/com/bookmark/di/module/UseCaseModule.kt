package com.bookmark.di.module

import com.bookmark.domain.repository.BookRepository
import com.bookmark.domain.usecase.BookUseCases
import com.bookmark.domain.usecase.club.feed.AddFeed
import com.bookmark.domain.usecase.club.feed.DeleteFeed
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideBookUseCase(
        repository : BookRepository
    ) : BookUseCases{
        return BookUseCases(
            addFeed = AddFeed(repository),
            deleteFeed = DeleteFeed(repository)
        )
    }
}