package com.example.bookmark.domain.usecase
import android.util.Log
import com.example.bookmark.data.repository.BookRepositoryImpl
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class SearchBooks @Inject constructor(
    private val repository : BookRepository
    ) {
    operator fun invoke(query : String):List<Book>{
        val data = repository.searchBooks(query)
        Log.e("UseCase",data.toString())
        return data
    }
}