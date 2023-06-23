package com.bookmark.data.network.remote

import com.bookmark.data.network.response.BookResponse
import com.bookmark.data.network.service.BookInfoApi
import com.bookmark.domain.model.book.Meta
import com.bookmark.domain.usecase.main.books.SearchBooks
import javax.inject.Inject

class BookRemote @Inject constructor(private val api: BookInfoApi) {
    suspend fun searchBooks(params: SearchBooks.Params): BookResponse {
        return api.searchBooks(params.query).body() ?: BookResponse(Meta(), emptyList())
    }
}