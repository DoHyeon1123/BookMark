package com.example.bookmark.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository

class AddBookInLibrary(private val repository : BookRepository) {
    operator fun invoke(info : Book){
        repository.addBookInLibrary(info)
    }
}