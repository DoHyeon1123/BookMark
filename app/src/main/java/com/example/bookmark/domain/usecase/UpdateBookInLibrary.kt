package com.example.bookmark.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository

class UpdateBookInLibrary(private val repository : BookRepository) {
    operator fun invoke(info : Book){
        return repository.updateBookInLibrary(info)
    }
}