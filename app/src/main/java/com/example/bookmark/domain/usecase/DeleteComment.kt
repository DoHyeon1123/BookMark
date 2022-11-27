package com.example.bookmark.domain.usecase
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import com.example.bookmark.domain.repository.BookRepository

class DeleteComment(private val repository : BookRepository) {
    operator fun invoke(bookId : String, id:Int){
        return repository.deleteComment(bookId,id)
    }
}