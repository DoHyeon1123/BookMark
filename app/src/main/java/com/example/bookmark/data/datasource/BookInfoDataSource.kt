package com.example.bookmark.data.datasource

import com.example.bookmark.data.api.remote.BookInfoRemote
import com.example.bookmark.data.db.cache.BookInfoCache
import com.example.bookmark.data.model.book.BookInfo

class BookInfoDataSource constructor(
    private val remote : BookInfoRemote,
    private val cache : BookInfoCache
){
    fun searchBookInfo(query : String):BookInfo{
        return remote.searchBookInfo(query)
    }
}