package com.example.bookmark.data.db.cache

import androidx.room.Dao
import androidx.room.Query
import com.example.bookmark.data.model.book.Documents

@Dao
interface BookInfoCache {
        @Query("")
        fun insertBookInfo(book : Documents)

        @Query("")
        fun getBookInfo():String
}