package com.example.bookmark.domain.repository

import com.example.bookmark.data.datasource.BookInfoDataSource
import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.data.db.CommentEntity
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment

interface BookRepository {
    //REST api
    fun searchBooks(keyWord : String):List<Book>

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