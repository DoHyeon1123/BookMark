package com.bookmark.presentation.domain.usecase
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class DeleteComment @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(bookId : String, id:Int){
        return repository.deleteComment(bookId,id)
    }
}