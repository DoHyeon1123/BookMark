package com.bookmark.domain.usecase.profile.library

import com.bookmark.domain.model.book.BookType
import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class InsertBookInLibrary @Inject constructor(private val repository : BookRepository) {

    data class Params(
        val title : String,
        val image : String,
        val contents : String,
        val authors : String,
        val url : String,
        val type : BookType,
        val reading_date : String,
        val id : String
    )
    fun invoke(params : Params) {
        repository.insertBookInLibrary(params)
    }
}