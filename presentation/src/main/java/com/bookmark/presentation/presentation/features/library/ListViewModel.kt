package com.bookmark.presentation.presentation.features.library

import androidx.lifecycle.MutableLiveData
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val useCases: BookUseCases) : BaseViewModel() {
    var list = MutableLiveData<List<Book>>()

    fun getBooksInLibrary(){
        list.value = useCases.getBooksInLibrary()

    }

}