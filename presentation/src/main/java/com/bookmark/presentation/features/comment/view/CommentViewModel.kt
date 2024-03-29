package com.bookmark.presentation.features.comment.view

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bookmark.domain.model.profile.Comment
import com.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(

) : BaseViewModel() {
    val comment = MutableLiveData<String>()
    val commentList = MutableLiveData<List<Comment>>()

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