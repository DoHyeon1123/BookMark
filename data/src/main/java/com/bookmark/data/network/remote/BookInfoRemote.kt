package com.bookmark.data.network.remote

import com.bookmark.data.network.response.BookResponse
import com.bookmark.data.network.service.BookInfoApi
import retrofit2.Call
import javax.inject.Inject

class BookInfoRemote @Inject constructor(private val api: BookInfoApi) {
    val apiKey = ""
    fun searchBookInfo(query : String): Call<BookResponse> {
        return api.searchBookInfo("KakaoAK ${apiKey}",query)
    }
}