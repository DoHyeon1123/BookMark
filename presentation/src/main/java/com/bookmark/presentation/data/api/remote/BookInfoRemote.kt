package com.bookmark.presentation.data.api.remote

import com.example.bookmark.data.util.Constants
import retrofit2.Call
import javax.inject.Inject

class BookInfoRemote @Inject constructor(private val api: com.bookmark.presentation.data.api.service.BookInfoApi) {
    fun searchBookInfo(query : String): Call<com.bookmark.presentation.data.book.BookResponse> {
        return api.searchBookInfo("KakaoAK ${Constants.API_KEY}",query)
    }
}