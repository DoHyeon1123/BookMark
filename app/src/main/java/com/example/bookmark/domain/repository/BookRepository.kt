package com.example.bookmark.domain.repository

import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment

interface BookRepository {
    //REST api
    fun getBooks():List<Book>
    fun searchBooks(keyWord : String):List<Book>

    //Room
    fun addBookInLibrary(info : Book)

    fun getBooksInLibrary():List<BookEntity>

    fun getBookInLibrary(id : Int):BookEntity
    fun updateBookInLibrary(info : Book)
    fun deleteBookInLibrary(id: Int)

    fun addComment(comment : Comment)
    fun updateComment(comment: Comment)
    fun deleteComment(id : Int)
}