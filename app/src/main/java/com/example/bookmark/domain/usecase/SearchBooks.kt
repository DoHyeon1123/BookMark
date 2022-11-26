package com.example.bookmark.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository

class SearchBooks(private val repository : BookRepository) {
    operator fun invoke(query : String):List<Book>{
        return repository.searchBooks(query)
    }
}