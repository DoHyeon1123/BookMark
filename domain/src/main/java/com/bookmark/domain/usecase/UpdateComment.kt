package com.bookmark.domain.usecase
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class UpdateComment @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(comment: String, bookId : String, id : Int){
        return repository.updateComment(comment, bookId, id)
    }
}