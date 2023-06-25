package com.bookmark.data.datasource

import com.bookmark.data.db.cache.BookCache
import com.bookmark.data.mapper.BookMapper
import com.bookmark.data.network.remote.BookRemote
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.usecase.main.books.SearchBooks
import com.bookmark.domain.usecase.profile.library.InsertBookInLibrary
import javax.inject.Inject

class BookDataSource @Inject constructor(
    private val remote : BookRemote,
    private val cache : BookCache
){
    private val mapper = BookMapper()
    suspend fun searchBooks(params : SearchBooks.Params) : List<Book> {
        return mapper.mapDocumentToBook(
            remote.searchBooks(params).documents
        )
    }

    suspend fun insertBookInLibrary(params : InsertBookInLibrary.Params) {
        cache.insertBookInfo(
            id = params.id,
            title = params.title,
            image = params.image,
            url = params.url,
            contents = params.contents,
            authors = params.authors,
            type = params.type,
            reading_date = params.reading_date
        )
    }
}