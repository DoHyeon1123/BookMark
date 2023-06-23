package com.bookmark.data.datasource

import com.bookmark.data.mapper.BookMapper
import com.bookmark.data.network.remote.BookRemote
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.usecase.main.books.SearchBooks
import javax.inject.Inject

class BookDataSource @Inject constructor(
    private val remote : BookRemote
){
    private val mapper = BookMapper()
    suspend fun searchBooks(params : SearchBooks.Params) : List<Book> {
        return mapper.mapDocumentToBook(
            remote.searchBooks(params).documents
        )
    }
}