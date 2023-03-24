package com.bookmark.domain.usecase
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class AddComment @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(comment: String, bookId : String){
        return repository.addComment(comment, bookId)
    }
}