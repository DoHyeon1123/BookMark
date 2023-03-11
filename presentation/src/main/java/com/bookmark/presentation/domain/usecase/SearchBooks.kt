package com.bookmark.presentation.domain.usecase
import android.util.Log
import com.example.bookmark.domain.repository.BookRepository
import retrofit2.Call
import javax.inject.Inject

class SearchBooks @Inject constructor(
    private val repository : BookRepository
    ) {
    operator fun invoke(query : String): Call<com.bookmark.presentation.data.book.BookResponse> {
        val data = repository.searchBooks(query)
        Log.e("UseCase",data.toString())
        return data
    }
}