package com.bookmark.data.repository

import com.bookmark.data.datasource.BookDataSource
import com.bookmark.data.network.remote.BookRemote
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.book.BookType
import com.bookmark.domain.model.profile.Comment
import com.bookmark.domain.repository.BookRepository
import com.bookmark.domain.usecase.main.books.SearchBooks
import com.bookmark.domain.usecase.profile.library.InsertBookInLibrary
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val dataSource: BookDataSource
) : BookRepository  {
    override suspend fun searchBooks(params: SearchBooks.Params): List<Book> = dataSource.searchBooks(params)

    override suspend fun insertBookInLibrary(params: InsertBookInLibrary.Params) {
       dataSource.insertBookInLibrary(params)
    }

    override suspend fun selectBookInLibrary(id: String): List<Book> {
        return dataSource.selectBook(id)
    }

    override suspend fun selectBookInLibrary(type: BookType): List<Book> {
        return dataSource.selectBook(type)
    }

    override suspend fun updateBookInLibrary(info: Book) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBookInLibrary(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getComment(bookId: String): List<Comment> {
        TODO("Not yet implemented")
    }

    override suspend fun addComment(comment: String, bookId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateComment(comment: String, bookId: String, id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteComment(bookId: String, id: Int) {
        TODO("Not yet implemented")
    }
}