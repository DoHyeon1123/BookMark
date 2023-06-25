package com.bookmark.domain.usecase.profile.library

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.book.BookType
import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class SelectBookInLibrary @Inject constructor(private val repository : BookRepository) {
    suspend operator fun invoke(id:String): List<Book> {
        return repository.selectBookInLibrary(id)
    }

    suspend operator fun invoke(type : BookType): List<Book> {
        return repository.selectBookInLibrary(type)
    }
}