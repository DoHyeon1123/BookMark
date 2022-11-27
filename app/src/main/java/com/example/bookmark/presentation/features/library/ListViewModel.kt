package com.example.bookmark.presentation.features.library

import androidx.lifecycle.MutableLiveData
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel

class ListViewModel(private val useCases: BookUseCases) : BaseViewModel() {
    var list = MutableLiveData<List<Book>>()

    fun getBooksInLibrary(){
        list.value = useCases.getBooksInLibrary()
    }
}