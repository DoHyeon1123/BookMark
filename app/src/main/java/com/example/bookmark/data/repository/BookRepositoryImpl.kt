package com.example.bookmark.data.repository

import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import com.example.bookmark.domain.repository.BookRepository

class BookRepositoryImpl : BookRepository {
    override fun getBooks(): List<Book> {
        TODO("Not yet implemented")
    }

    override fun searchBooks(keyWord: String): List<Book> {
        TODO("Not yet implemented")
    }

    override fun addBookInLibrary(info: Book) {
        TODO("Not yet implemented")
    }

    override fun getBooksInLibrary(): List<BookEntity> {
        TODO("Not yet implemented")
    }

    override fun getBookInLibrary(id: Int): BookEntity {
        TODO("Not yet implemented")
    }

    override fun updateBookInLibrary(info: Book) {
        TODO("Not yet implemented")
    }

    override fun deleteBookInLibrary(id: Int) {
        TODO("Not yet implemented")
    }

    override fun addComment(comment: Comment) {
        TODO("Not yet implemented")
    }

    override fun updateComment(comment: Comment) {
        TODO("Not yet implemented")
    }

    override fun deleteComment(id: Int) {
        TODO("Not yet implemented")
    }
}