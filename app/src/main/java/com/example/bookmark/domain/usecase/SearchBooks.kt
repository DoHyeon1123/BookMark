package com.example.bookmark.domain.usecase
import android.util.Log
import com.example.bookmark.data.book.BookResponse
import com.example.bookmark.data.repository.BookRepositoryImpl
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class SearchBooks @Inject constructor(
    private val repository : BookRepository
    ) {
    operator fun invoke(query : String): Call<BookResponse> {
        val data = repository.searchBooks(query)
        Log.e("UseCase",data.toString())
        return data
    }
}