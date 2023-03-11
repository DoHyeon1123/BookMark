package com.bookmark.presentation.presentation.features.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookmark.data.mapper.BookMapper
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: BookUseCases
) : BaseViewModel() {
    val bookList = MutableLiveData<List<Book>>()
    val query = MutableLiveData<String>()

    val mapper = BookMapper()

    fun searchBooks(){
            useCases.searchBooks(query.value ?: "책갈피").enqueue(object : retrofit2.Callback<com.bookmark.presentation.data.book.BookResponse>{
                override fun onResponse(call: Call<com.bookmark.presentation.data.book.BookResponse>, response: Response<com.bookmark.presentation.data.book.BookResponse>) {
                    bookList.value = mapper.mapDocumentToBook(response.body()?.documents ?: emptyList())
                    Log.e("DataSource",bookList.value.toString())
                }

                override fun onFailure(call: Call<com.bookmark.presentation.data.book.BookResponse>, t: Throwable) {
                    Log.e("DataSource",t.toString())
                }
            })
    }
    fun addBookInLibrary(info : Book){
        useCases.addBookInLibrary(info)
    }
}