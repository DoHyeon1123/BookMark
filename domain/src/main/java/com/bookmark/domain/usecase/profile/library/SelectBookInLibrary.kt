package com.bookmark.domain.usecase.profile.library

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.book.BookType
import com.bookmark.domain.repository.BookRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SelectBookInLibrary @Inject constructor(private val repository : BookRepository) {
    suspend operator fun invoke(id:String): List<Book> {
        return repository.selectBookInLibrary(id)
    }

    suspend operator fun invoke(type : BookType) = kotlin.runCatching {
        flow {
            emit(repository.selectBookInLibrary(type))
        }// flow 빌더 안에 값을 반환하는 함수를 emit을 통해 flow 흐름에 흘려보낸다.
    }
}