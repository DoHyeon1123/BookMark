package com.example.bookmark.data.api.remote

import com.example.bookmark.data.api.service.BookInfoApi
import com.example.bookmark.data.book.BookResponse
import com.example.bookmark.data.util.Constants
import retrofit2.Call
import javax.inject.Inject

class BookInfoRemote @Inject constructor(private val api: BookInfoApi) {
    fun searchBookInfo(query : String): Call<BookResponse> {
        return api.searchBookInfo("KakaoAK ${Constants.API_KEY}",query)
    }
}