package com.example.bookmark.presentation.features.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases : BookUseCases
) : BaseViewModel() {
    val bookList = MutableLiveData<List<Book>>()
    val query = MutableLiveData<String>()

    fun searchBooks(){
            CoroutineScope(Dispatchers.IO).launch {
                bookList.value = useCases.searchBooks(query.value ?: "책")
                Log.e("HomeViewModel",bookList.value.toString())
            }
    }
}