package com.bookmark.presentation.features.profile.view

import androidx.lifecycle.MutableLiveData
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.usecase.BookUseCases
import com.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(

    ) : BaseViewModel() {
    var list = MutableLiveData<List<Book>>()

    /*fun getBooksInLibrary(){
        list.value = useCases.getBooksInLibrary()

    }*/

}