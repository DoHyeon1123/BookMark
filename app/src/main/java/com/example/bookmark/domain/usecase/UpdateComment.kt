package com.example.bookmark.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class UpdateComment @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(comment: String, bookId : String, id : Int){
        return repository.updateComment(comment, bookId, id)
    }
}