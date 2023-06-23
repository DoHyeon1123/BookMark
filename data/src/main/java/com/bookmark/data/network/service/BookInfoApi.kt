package com.bookmark.data.network.service

import com.bookmark.data.network.response.BookResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface BookInfoApi {
    @GET("search/book")
    suspend fun searchBooks(
        @Query("query") query : String
    ) : Response<BookResponse>
}