package com.example.bookmark.presentation.features.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases : BookUseCases
) : BaseViewModel() {
    val bookList = MutableLiveData<List<Book>>()
    val query = MutableLiveData<String>()
    var job: Job? = null

    fun searchBooks(){

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = useCases.searchBooks(query.value ?: "책갈피")
            Log.e("HomeViewModel",response.toString())
            withContext(Dispatchers.Main){
                delay(1000L)
                bookList.value = response
                Log.e("HomeViewModel",response.toString())
            }
        }

    }
    fun stopJob(){
        job?.cancel("",null)
    }
}