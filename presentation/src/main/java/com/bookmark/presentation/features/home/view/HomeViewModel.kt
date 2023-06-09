package com.bookmark.presentation.features.home.view

import androidx.lifecycle.MutableLiveData
import com.bookmark.domain.model.profile.Comment
import com.bookmark.domain.usecase.BookUseCases
import com.bookmark.domain.usecase.main.books.SearchBooks
import com.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: BookUseCases
) : BaseViewModel() {
    val comment = MutableLiveData<String>()
    val commentList = MutableLiveData<List<Comment>>()

    suspend fun searchBook(query : String) {
        useCases.searchBooks(SearchBooks.Params(query))

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