package com.bookmark.presentation.features.club.view

import android.telecom.Call
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bookmark.domain.mapper.BookMapper
import com.bookmark.domain.model.Book
import com.bookmark.domain.model.response.BookResponse
import com.bookmark.domain.usecase.BookUseCases
import com.bookmark.presentation.base.BaseViewModel
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
class ClubViewModel @Inject constructor(
    private val useCases: BookUseCases
) : BaseViewModel() {
    val bookList = MutableLiveData<List<Book>>()
    val query = MutableLiveData<String>()

    val mapper = BookMapper()

    fun searchBooks(){
            useCases.searchBooks(query.value ?: "책갈피").enqueue(object : retrofit2.Callback<com.bookmark.domain.model.response.BookResponse>{
                override fun onResponse(call: Call<BookResponse>, response: Response<com.bookmark.domain.model.response.BookResponse>) {
                    bookList.value = mapper.mapDocumentToBook(response.body()?.documents ?: emptyList())
                    Log.e("DataSource",bookList.value.toString())
                }

                override fun onFailure(call: Call<com.bookmark.domain.model.response.BookResponse>, t: Throwable) {
                    Log.e("DataSource",t.toString())
                }
            })
    }
    fun addBookInLibrary(info : Book){
        useCases.addBookInLibrary(info)
    }
}