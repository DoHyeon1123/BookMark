package com.example.bookmark.data.api.remote

import com.example.bookmark.data.api.service.BookInfoApi
import com.example.bookmark.data.book.BookResponse
import com.example.bookmark.data.util.Constants

class BookInfoRemote(val api: BookInfoApi) {
    fun searchBookInfo(query : String): BookResponse {
        return api.searchBookInfo(Constants.API_KEY,query)
    }
}