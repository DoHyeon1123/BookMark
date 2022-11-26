package com.example.bookmark.presentation.features.home

import androidx.lifecycle.MutableLiveData
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel
import kotlinx.coroutines.*

class HomeViewModel(
    private val useCases : BookUseCases
) : BaseViewModel() {
    val bookList = MutableLiveData<List<Book>>()

    fun searchBooks(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            bookList.value = useCases.searchBooks(query)

        }
    }
}