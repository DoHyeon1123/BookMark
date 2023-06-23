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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
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
            ).onSuccess { flow ->
                flow.onStart {
                    _getBooksState.emit(
                        GetBooksState(
                            isLoading = true
                        )
                    )
                }.collectLatest { data ->
                    _getBooksState.emit(
                        GetBooksState(
                            bookList = data,
                            isLoading = false
                        )
                    )
                    Log.d("HomeViewModel_searchBooks()", data.toString())
                }
            }.onFailure {err ->
                _getBooksState.emit(
                    GetBooksState(
                        error = "목록을 불러오는 데에 실패했습니다",
                        isLoading = false
                    )
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