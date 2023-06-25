package com.bookmark.domain.usecase.profile.library

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class SelectBookInLibrary @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(id:String): Book {
        return repository.getBookInLibrary(id)
    }
}