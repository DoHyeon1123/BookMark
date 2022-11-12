package com.example.bookmark.data.api.service

import retrofit2.http.GET


interface BookInfoApi {
    @GET("/v3/search/book")
    fun searchBookInfo() 
}