package com.example.bookmark.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookmark.data.db.cache.BookInfoCache

class DataBases {
    @Database(entities = [BookEntity::class, CommentEntity::class], version = 2,exportSchema = false)//version은 구조 변경 시 구버전과 구분할 수 있도록 해준다.

    abstract class bookMarkDatabase: RoomDatabase() {
        //RoomDatabase()를 상속받는 DataBase 추상 클래스를 작성한다.
        //작성한 Dao를 정의
        abstract fun bookInfoDao(): BookInfoCache
    }
    companion object {
        private var instance: bookMarkDatabase? = null

        @Synchronized
        fun getInstance(context: Context): bookMarkDatabase? {
            if (instance == null) {
                synchronized(bookMarkDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        bookMarkDatabase::class.java,
                        "book-database"//사용할 데이터베이스 이름
                    ).build()
                }
            }
            return instance
        }
    }
}