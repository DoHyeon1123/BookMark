package com.example.bookmark.data.datasource

import com.example.bookmark.data.api.remote.BookInfoRemote
import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.data.db.cache.BookInfoCache
import com.example.bookmark.data.book.Document
import com.example.bookmark.data.db.CommentEntity
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import java.time.LocalDate

class BookInfoDataSource constructor(
    private val remote : BookInfoRemote,
    private val cache : BookInfoCache
){
    private fun mapDocumentToBook(list : List<Document>) : List<Book>{
        val newList : MutableList<Book> = listOf<Book>() as MutableList<Book>
        list.map {
            newList.add(Book(
                title = it.title,
                image = it.thumbnail,
                author = it.authors.toString(),
                content = it.contents,
                url = it.url,
                id = it.isbn
            )
            )
        }
        return newList
    }

    fun searchBooks(query : String): List<Book>{
        return mapDocumentToBook(remote.searchBookInfo(query).documents)
    }
    fun addBookInLibrary(info : Book){
        cache.insertBookInfo(
            info.id,
            info.title,
            info.image,
            info.url,
            info.content,
            info.author
        )
    }
    fun getBooksInLibrary():List<BookEntity>{
        return cache.selectAllBooks()
    }

    fun getBookInLibrary(id : String):BookEntity {
        return cache.selectBook(id)
    }

    fun updateBookInLibrary(info: Book) {
        TODO("Not yet implemented")
    }

    fun deleteBookInLibrary(id: String) {
        cache.deleteBook(id)
    }

    fun getComments(bookId: String, ):List<CommentEntity>{
        return cache.selectComments(bookId)
    }

    fun addComment(comment: String, bookId : String) {
        cache.insertComment(bookId, comment, LocalDate.now().toString())
    }

    fun updateComment(comment: String, bookId : String, id : Int) {
        cache.updateComment(bookId, comment, LocalDate.now().toString(), id)
    }

    fun deleteComment(bookId : String, id: Int) {
        cache.deleteComment(bookId, id)
    }
}