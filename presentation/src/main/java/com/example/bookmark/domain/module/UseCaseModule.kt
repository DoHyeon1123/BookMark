package com.example.bookmark.domain.module

import com.example.bookmark.domain.repository.BookRepository
import com.example.bookmark.domain.usecase.*
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
            searchBooks = SearchBooks(repository),
            addBookInLibrary = AddBookInLibrary(repository),
            getBookInLibrary = GetBookInLibrary(repository),
            getBooksInLibrary = GetBooksInLibrary(repository),
            getComment = GetComment(repository),
            deleteBookInLibrary = DeleteBookInLibrary(repository),
            deleteComment = DeleteComment(repository),
            addComment = AddComment(repository),
            updateBookInLibrary = UpdateBookInLibrary(repository),
            updateComment = UpdateComment(repository)
        )
    }
}