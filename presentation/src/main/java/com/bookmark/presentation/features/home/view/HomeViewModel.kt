package com.bookmark.presentation.features.home.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bookmark.domain.model.profile.Comment
import com.bookmark.domain.usecase.BookUseCases
import com.bookmark.domain.usecase.main.books.SearchBooks
import com.bookmark.presentation.base.BaseViewModel
import com.bookmark.presentation.features.home.state.GetBooksState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: BookUseCases
) : BaseViewModel() {
    val query = MutableLiveData<String>()
    val commentList = MutableLiveData<List<Comment>>()

    private val _getBooksState = MutableStateFlow(GetBooksState())
    val getBooksState: StateFlow<GetBooksState> = _getBooksState

    fun searchBook() {
        viewModelScope.launch {
            useCases.searchBooks(
                SearchBooks.Params(query.value ?: "안드로이드")
            ).onSuccess {
                it.collect { data ->
                    _getBooksState.emit(
                        GetBooksState(
                            isLoading = false
                        )
                    //TODO 인자값 넣고 Loading 상태 해결할 방안 생각하기
                    )
                    Log.d("HomeViewModel_searchBooks()", data.toString())
                }
            }.onFailure {err ->
                _getBooksState.emit(
                    GetBooksState()
                )
                Log.d("HomeViewModel_searchBooks()", err.toString())

            }
        }
    }
    /*fun deleteComment(bookId : String, id : Int){
        useCases.deleteComment(bookId, id)
        getComment(bookId)
    }

    fun getComment(bookId : String){
        commentList.value = useCases.getComment(bookId)
        Log.e("CommentViewModel",useCases.getComment(bookId).toString())
    }

    fun addComment(bookId: String){
        useCases.addComment(comment.value ?: "댓글이 정상적으로 처리되지 못함", bookId)
        getComment(bookId)
    }*/
}