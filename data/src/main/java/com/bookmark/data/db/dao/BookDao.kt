package com.bookmark.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.bookmark.data.db.entity.BookEntity
import com.bookmark.data.db.entity.CommentEntity
import com.bookmark.domain.model.book.BookType

@Dao
interface BookDao {
        @Query("INSERT INTO Library(id, authors, title, image, contents, url, type, reading_date) " +
                "VALUES(:id,:authors, :title, :image, :contents, :url, :type, :reading_date)")
        suspend fun insertBookInfo(
            id : String,
            title : String,
            image : String,
            url : String,
            contents : String,
            authors : String,
            type : BookType,
            reading_date : String
            )

        @Query("SELECT * FROM Library WHERE type = :type")
        suspend fun selectBookByType(type : BookType):List<BookEntity>

        @Query("SELECT * FROM Library Where id = :id")
        suspend fun selectBookById(id : String): List<BookEntity>

        @Query("DELETE FROM Library Where id = :id")
        fun deleteBook(id : String)

        @Query("SELECT * FROM Comments Where bookId = :bookId")
        fun selectComments(bookId: String):List<CommentEntity>

        @Query("INSERT INTO Comments(bookId, comment, dateTime) VALUES(:bookId ,:comment,:dateTime)")
        fun insertComment(bookId : String, comment: String, dateTime : String)

    @Query("DELETE FROM Comments WHERE bookId = :bookId & id = :id")
    fun deleteComment(bookId : String, id : Int)

    @Query("UPDATE Comments SET comment = :comment, dateTime = :dateTime WHERE bookId = :bookId & id = :id")
    fun updateComment(bookId : String, comment: String, dateTime : String, id : Int)

    //TODO User 회원가입 정보를 저장해서 꺼내 써야함




}