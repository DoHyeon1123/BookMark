package com.bookmark.domain.repository

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.Comment


interface BookRepository {
    //REST api
    fun searchBooks(keyWord : String): Book

    //Room
    fun addBookInLibrary(info : Book)

    fun getBooksInLibrary():List<Book>

    fun getBookInLibrary(id : String): Book
    fun updateBookInLibrary(info : Book)
    fun deleteBookInLibrary(id: String)

    fun getComment(bookId : String) : List<Comment>
    fun addComment(comment : String, bookId: String)
    fun updateComment(comment: String, bookId: String, id: Int)
    fun deleteComment(bookId : String, id : Int)
}