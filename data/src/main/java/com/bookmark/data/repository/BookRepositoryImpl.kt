package com.bookmark.data.repository

import com.bookmark.data.network.remote.BookInfoRemote
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.Comment
import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val remote: BookInfoRemote
) : BookRepository  {
    override fun searchBooks(keyWord: String): Book {
        TODO("Not yet implemented")
    }

    override fun addBookInLibrary(info: Book) {
        TODO("Not yet implemented")
    }

    override fun getBooksInLibrary(): List<Book> {
        TODO("Not yet implemented")
    }

    override fun getBookInLibrary(id: String): Book {
        TODO("Not yet implemented")
    }

    override fun updateBookInLibrary(info: Book) {
        TODO("Not yet implemented")
    }

    override fun deleteBookInLibrary(id: String) {
        TODO("Not yet implemented")
    }

    override fun getComment(bookId: String): List<Comment> {
        TODO("Not yet implemented")
    }

    override fun addComment(comment: String, bookId: String) {
        TODO("Not yet implemented")
    }

    override fun updateComment(comment: String, bookId: String, id: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteComment(bookId: String, id: Int) {
        TODO("Not yet implemented")
    }
}