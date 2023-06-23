package com.bookmark.domain.usecase.main.books

import android.util.Log
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchBooks @Inject constructor(private val repository : BookRepository) {
    data class Params (
        val query : String = "추천 도서"
        )
    suspend operator fun invoke(params : Params) = kotlin.runCatching {
        flow {
            emit(repository.searchBooks(params))
        }// flow 빌더 안에 값을 반환하는 함수를 emit을 통해 flow 흐름에 흘려보낸다.
    }
}