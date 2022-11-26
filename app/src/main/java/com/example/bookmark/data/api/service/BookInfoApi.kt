package com.example.bookmark.data.api.service

import com.example.bookmark.data.book.BookResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface BookInfoApi {
    @GET("/v3/search/book")
    fun searchBookInfo(
        @Header("Authorization") key: String,
        @Query("query") query : String
    ) : BookResponse
}