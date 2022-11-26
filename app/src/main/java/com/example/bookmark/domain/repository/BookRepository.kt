package com.example.bookmark.domain.repository

import com.example.bookmark.data.datasource.BookInfoDataSource
import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment

interface BookRepository {
    val dataSource :BookInfoDataSource
    //REST api
    fun searchBooks(keyWord : String):List<Book>

    //Room
    fun addBookInLibrary(info : Book)

    fun getBooksInLibrary():List<BookEntity>

    fun getBookInLibrary(id : Int):BookEntity
    fun updateBookInLibrary(info : Book)
    fun deleteBookInLibrary(id: Int)

    fun getComment(bookId : String)
    fun addComment(comment : Comment)
    fun updateComment(comment: Comment)
    fun deleteComment(id : Int)
}