package com.example.bookmark.data.util

import com.example.bookmark.data.model.BookInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.API_HOST)
        .addConverterFactory(GsonConverterFactory.create()).build();
    val service: BookInfo = retrofit.create(BookInfo::class.java);
}