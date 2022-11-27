package com.example.bookmark.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class DeleteBookInLibrary @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(id : String){
        return repository.deleteBookInLibrary(id)
    }
}