package com.example.bookmark.data.api.service

import com.example.bookmark.data.book.BookInfo
import retrofit2.http.GET


interface BookInfoApi {
    @GET("/v3/search/book")
    fun searchBookInfo(
        query : String
    ) : BookInfo
}