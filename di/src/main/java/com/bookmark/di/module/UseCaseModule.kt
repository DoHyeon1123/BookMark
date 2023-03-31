package com.bookmark.di.module

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