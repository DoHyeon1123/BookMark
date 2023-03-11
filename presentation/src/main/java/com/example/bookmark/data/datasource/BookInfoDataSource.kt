package com.example.bookmark.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookmark.data.api.remote.BookInfoRemote
import com.example.bookmark.data.book.BookResponse
import com.example.bookmark.data.db.cache.BookCache
import com.example.bookmark.data.db.dao.BookDao
import com.example.bookmark.data.mapper.BookMapper
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

class BookInfoDataSource  @Inject constructor(
    private val remote : BookInfoRemote,
    private val cache : BookCache,
){
    private val mapper = BookMapper()
    var list : List<Book> = listOf()

    fun searchBooks(query : String) : Call<BookResponse>{
        return remote.searchBookInfo(query)
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
