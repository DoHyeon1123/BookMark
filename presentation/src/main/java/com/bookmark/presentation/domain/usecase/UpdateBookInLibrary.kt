package com.bookmark.presentation.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class UpdateBookInLibrary @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(info : Book){
        return repository.updateBookInLibrary(info)
    }
}