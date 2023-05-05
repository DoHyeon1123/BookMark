package com.bookmark.presentation.features.home.view

import android.util.Log


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: BookUseCases
) : BaseViewModel() {
    val comment = MutableLiveData<String>()
    val commentList = MutableLiveData<List<Comment>>()

    fun deleteComment(bookId : String, id : Int){
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
    }
}