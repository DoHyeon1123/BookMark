package com.example.bookmark.data.datasource

import android.util.Log
import androidx.room.Entity
import com.example.bookmark.data.api.remote.BookInfoRemote
import com.example.bookmark.data.book.BookResponse
import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.data.db.cache.BookInfoCache
import com.example.bookmark.data.book.Document
import com.example.bookmark.data.db.CommentEntity
import com.example.bookmark.data.mapper.BookMapper
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate

class BookInfoDataSource constructor(
    private val remote : BookInfoRemote,
    private val cache : BookInfoCache,
    private val mapper: BookMapper
){

    fun searchBooks(query : String): List<Book>{
        var list : List<Book> = listOf()
        remote.searchBookInfo(query).enqueue(object : retrofit2.Callback<BookResponse>{
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                list = mapper.mapDocumentToBook(response.body()!!.documents)
            }

            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return list
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
    fun getBooksInLibrary():List<Book>{
        return mapper.mapEntityToBook(cache.selectAllBooks())
    }

    fun getBookInLibrary(id : String):Book {
        return mapper.mapEntityToBook(cache.selectBook(id))
    }

    fun updateBookInLibrary(info: Book) {
        TODO("Not yet implemented")
    }

    fun deleteBookInLibrary(id: String) {
        cache.deleteBook(id)
    }

    fun getComments(bookId: String, ):List<Comment>{
        return mapper.mapEntityToComment(cache.selectComments(bookId))
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
