package com.bookmark.domain.usecase.profile.library

import com.bookmark.domain.model.Book
import com.bookmark.domain.repository.BookRepository

class GetLibraryInfo @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(id:String): Book {
        return repository.getBookInLibrary(id)
    }
}