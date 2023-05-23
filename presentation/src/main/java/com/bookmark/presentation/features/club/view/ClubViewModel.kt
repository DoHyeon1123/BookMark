package com.bookmark.presentation.features.club.view

import android.telecom.Call
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bookmark.data.mapper.BookMapper
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.response.BookResponse
import com.bookmark.domain.usecase.BookUseCases
import com.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ClubViewModel @Inject constructor(
    private val useCases: BookUseCases
) : BaseViewModel() {
    val bookList = MutableLiveData<List<Book>>()
    val query = MutableLiveData<String>()

    val mapper = com.bookmark.data.mapper.BookMapper()

    fun searchBooks(){
            useCases.searchBooks(query.value ?: "책갈피").enqueue(object : retrofit2.Callback<BookResponse>{
                override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                    bookList.value = mapper.mapDocumentToBook(response.body()?.documents ?: emptyList())
                    Log.e("DataSource",bookList.value.toString())
                }

                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    Log.e("DataSource",t.toString())
                }
            })
    }
    fun addBookInLibrary(info : Book){
        useCases.addBookInLibrary(info)
    }
}