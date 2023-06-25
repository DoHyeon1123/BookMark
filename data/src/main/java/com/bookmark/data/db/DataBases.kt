package com.bookmark.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bookmark.data.db.dao.BookDao
import com.bookmark.data.db.entity.BookEntity
import com.bookmark.data.db.entity.CommentEntity
import com.bookmark.data.db.entity.UserEntity

class DataBases {
    @Database(entities = [BookEntity::class, CommentEntity::class, UserEntity::class], version = 4,exportSchema = false)//version은 구조 변경 시 구버전과 구분할 수 있도록 해준다.

    abstract class BookMarkDatabase: RoomDatabase() {
        //RoomDatabase()를 상속받는 DataBase 추상 클래스를 작성한다.
        //작성한 Dao를 정의
        abstract fun bookInfoDao(): BookDao
    }
    companion object {
        private var instance: BookMarkDatabase? = null
        @Synchronized
        fun getInstance(context: Context): BookMarkDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookMarkDatabase::class.java, "book_database"
                )
                   /* .setQueryCallback({ sqlQuery, bindArgs ->
                        println("SQL Query: $sqlQuery SQL Args: $bindArgs")
                    }, Executors.newSingleThreadExecutor())*/
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}