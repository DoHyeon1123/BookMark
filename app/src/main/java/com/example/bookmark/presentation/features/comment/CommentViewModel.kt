package com.example.bookmark.presentation.features.comment

import androidx.lifecycle.MutableLiveData
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val useCases: BookUseCases
) : BaseViewModel() {
    val comment = MutableLiveData<String>()

    fun deleteComment(bookId : String, id : Int){
        useCases.deleteComment(bookId, id)
    }

    fun addComment(bookId: String){
        useCases.addComment(comment.value ?: "댓글이 정상적으로 처리되지 못함", bookId)
    }
}