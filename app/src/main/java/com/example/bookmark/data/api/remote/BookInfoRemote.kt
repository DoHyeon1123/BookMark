package com.example.bookmark.data.api.remote

import com.example.bookmark.data.api.service.BookInfoApi
import com.example.bookmark.data.model.book.BookInfo

class BookInfoRemote(val api: BookInfoApi) {
    fun searchBookInfo(query : String):BookInfo{
        return api.searchBookInfo(query)
    }
}