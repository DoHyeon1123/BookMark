package com.bookmark.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class GetBooksInLibrary @Inject constructor(private val repository : BookRepository) {
    operator fun invoke():List<Book>{
        return repository.getBooksInLibrary()
    }
}