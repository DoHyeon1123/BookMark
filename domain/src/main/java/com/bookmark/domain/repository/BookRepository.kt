package com.bookmark.domain.repository

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.Comment
import com.bookmark.domain.usecase.main.books.SearchBooks
import com.bookmark.domain.usecase.profile.library.InsertBookInLibrary


interface BookRepository {
    //REST api
    suspend fun searchBooks(params : SearchBooks.Params): List<Book>

    //Room
    suspend fun insertBookInLibrary(params : InsertBookInLibrary.Params)
    suspend fun selectBookInLibrary():List<Book>
    suspend fun updateBookInLibrary(info : Book)
    suspend fun deleteBookInLibrary(id: String)

    suspend fun getComment(bookId : String) : List<Comment>
    suspend fun addComment(comment : String, bookId: String)
    suspend fun updateComment(comment: String, bookId: String, id: Int)
    suspend fun deleteComment(bookId : String, id : Int)
}