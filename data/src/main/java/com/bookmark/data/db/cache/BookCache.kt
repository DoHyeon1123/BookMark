package com.bookmark.data.db.cache

import android.app.Application
import com.bookmark.data.db.entity.BookEntity
import com.bookmark.data.db.entity.CommentEntity
import com.bookmark.domain.model.book.BookType
import javax.inject.Inject

class BookCache @Inject constructor(application: Application) : BaseCache(application){
    suspend fun insertBookInLibrary(
        id : String,
        title : String,
        image : String,
        url : String,
        contents : String,
        authors : String,
        type : BookType,
        reading_date : String
    ) {
        return database.bookInfoDao().insertBookInfo(id, title, image, url, contents, authors, type,reading_date)
    }

    suspend fun selectBook(type : BookType):List<BookEntity>{
        return database.bookInfoDao().selectBookByType(type)
    }

    suspend fun selectBook(id : String) : List<BookEntity>{
        return database.bookInfoDao().selectBookById(id)
    }

    fun deleteBook(id : String){
        database.bookInfoDao().deleteBook(id)
    }

    fun selectComments(bookId: String):List<CommentEntity>{
        return database.bookInfoDao().selectComments(bookId)
    }

    fun insertComment(bookId : String, comment: String, dateTime : String){
        return database.bookInfoDao().insertComment(bookId, comment, dateTime)
    }
    fun deleteComment(bookId : String, id : Int){
        database.bookInfoDao().deleteComment(bookId, id)
    }
    fun updateComment(bookId : String, comment: String, dateTime : String, id : Int){
        return database.bookInfoDao().updateComment(bookId, comment, dateTime, id)
    }
}