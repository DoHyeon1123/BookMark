package com.bookmark.domain.usecase

data class BookUseCases(
    val searchBooks: SearchBooks,
    val addBookInLibrary: AddBookInLibrary,
    val getBooksInLibrary: GetBooksInLibrary,
    val getBookInLibrary: GetBookInLibrary,
    val updateBookInLibrary: UpdateBookInLibrary,
    val deleteBookInLibrary: DeleteBookInLibrary,
    val getComment: GetComment,
    val addComment: AddComment,
    val updateComment: UpdateComment,
    val deleteComment: DeleteComment
)
