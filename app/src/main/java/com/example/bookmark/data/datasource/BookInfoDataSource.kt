package com.example.bookmark.data.datasource

import com.example.bookmark.data.api.remote.BookInfoRemote
import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.data.db.cache.BookInfoCache
import com.example.bookmark.data.book.BookInfo
import com.example.bookmark.data.book.Documents

class BookInfoDataSource constructor(
    private val remote : BookInfoRemote,
    private val cache : BookInfoCache
){
    fun searchBookInfo(query : String): BookInfo {
        return remote.searchBookInfo(query)
    }
    fun insertBookInfo(book : Documents){
        cache.insertBookInfo(
            book.title,
            book.thumbnail,
            book.contents,
            book.url,
            book.authors.toString()

        )
    }
    fun getAllBookInfo():List<BookEntity>{
        return cache.getAllBookInfo()
    }
}