package com.bookmark.presentation.domain.repository

import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import retrofit2.Call

interface BookRepository {
    //REST api
    fun searchBooks(keyWord : String): Call<com.bookmark.presentation.data.book.BookResponse>

    //Room
    fun addBookInLibrary(info : Book)

    fun getBooksInLibrary():List<Book>

    fun getBookInLibrary(id : String):Book
    fun updateBookInLibrary(info : Book)
    fun deleteBookInLibrary(id: String)

    fun getComment(bookId : String) : List<Comment>
    fun addComment(comment : String, bookId: String)
    fun updateComment(comment: String, bookId: String, id: Int)
    fun deleteComment(bookId : String, id : Int)
}