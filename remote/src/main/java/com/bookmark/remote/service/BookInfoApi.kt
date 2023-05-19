package com.bookmark.remote.service

import com.bookmark.remote.response.BookResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface BookInfoApi {
    @GET("/v3/search/book")
    fun searchBookInfo(
        @Header("Authorization") key: String,
        @Query("query") query : String
    ) : Call<BookResponse>
}