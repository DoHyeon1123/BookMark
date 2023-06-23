package com.bookmark.presentation.repository


import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.Comment
import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

/*class BookRepositoryImpl @Inject constructor(
    private val dataSource: BookInfoDataSource
    ) : BookRepository {

    override fun searchBooks(keyWord: String): Book {
        return dataSource.searchBooks(keyWord)
    }

    override fun addBookInLibrary(info: Book) {
        dataSource.addBookInLibrary(info)
    }

    override fun getBooksInLibrary(): List<Book> {
        return dataSource.getBooksInLibrary()
    }

    override fun getBookInLibrary(id: String): Book {
        return dataSource.getBookInLibrary(id)
    }

    override fun updateBookInLibrary(info: Book) {
        return dataSource.updateBookInLibrary(info)
    }

    override fun deleteBookInLibrary(id: String) {
        return dataSource.deleteBookInLibrary(id)
    }

    override fun getComment(bookId: String):List<Comment> {
        return dataSource.getComments(bookId)
    }

    override fun addComment(comment: String, bookId: String) {
        dataSource.addComment(comment, bookId)
    }

    override fun updateComment(comment: String, bookId: String, id: Int) {
        dataSource.updateComment(comment,bookId,id)
    }

    override fun deleteComment(bookId:String, id: Int) {
        dataSource.deleteComment(bookId,id)
    }
}*/