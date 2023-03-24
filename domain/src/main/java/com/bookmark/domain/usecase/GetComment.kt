package com.bookmark.domain.usecase
import com.example.bookmark.domain.model.Comment
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class GetComment @Inject constructor(private val repository : BookRepository) {
    operator fun invoke(bookId : String):List<Comment>{
        return repository.getComment(bookId)
    }
}