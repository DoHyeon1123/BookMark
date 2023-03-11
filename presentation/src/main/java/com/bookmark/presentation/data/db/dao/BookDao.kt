package com.bookmark.presentation.data.db.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface BookDao {
        @Query("INSERT INTO Library(id, authors, title, image, contents, url) VALUES(:id,:authors, :title, :image, :contents, :url)")
        fun insertBookInfo(
            id : String,
            title : String,
            image : String,
            url : String,
            contents : String,
            authors : String )

        @Query("SELECT * FROM Library")
        fun selectAllBooks():List<com.bookmark.presentation.data.db.BookEntity>

        @Query("SELECT * FROM Library Where id = :id")
        fun selectBook(id : String): com.bookmark.presentation.data.db.BookEntity

        @Query("DELETE FROM Library Where id = :id")
        fun deleteBook(id : String)

        @Query("SELECT * FROM Comments Where bookId = :bookId")
        fun selectComments(bookId: String):List<com.bookmark.presentation.data.db.CommentEntity>

        @Query("INSERT INTO Comments(bookId, comment, dateTime) VALUES(:bookId ,:comment,:dateTime)")
        fun insertComment(bookId : String, comment: String, dateTime : String)

    @Query("DELETE FROM Comments WHERE bookId = :bookId & id = :id")
    fun deleteComment(bookId : String, id : Int)

    @Query("UPDATE Comments SET comment = :comment, dateTime = :dateTime WHERE bookId = :bookId & id = :id")
    fun updateComment(bookId : String, comment: String, dateTime : String, id : Int)




}