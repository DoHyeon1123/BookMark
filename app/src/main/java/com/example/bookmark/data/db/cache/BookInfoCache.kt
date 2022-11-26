package com.example.bookmark.data.db.cache

import androidx.room.Dao
import androidx.room.Query
import com.example.bookmark.data.db.BookEntity

@Dao
interface BookInfoCache {
        @Query("INSERT INTO BookInfo(authors, title, image, contents, url) VALUES(:authors, :title, :image, :contents, :url)")
        fun insertBookInfo(title : String,
                           image : String,
                           url : String,
                           contents : String,
                           authors : String )

        @Query("SELECT * FROM BookInfo")
        fun getAllBookInfo():List<BookEntity>
}