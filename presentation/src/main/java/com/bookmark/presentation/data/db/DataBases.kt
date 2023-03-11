package com.bookmark.presentation.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookmark.data.db.dao.BookDao
import java.util.concurrent.Executors

class DataBases {
    @Database(entities = [_root_ide_package_.com.bookmark.presentation.data.db.BookEntity::class, _root_ide_package_.com.bookmark.presentation.data.db.CommentEntity::class], version = 2,exportSchema = false)//version은 구조 변경 시 구버전과 구분할 수 있도록 해준다.

    abstract class BookMarkDatabase: RoomDatabase() {
        //RoomDatabase()를 상속받는 DataBase 추상 클래스를 작성한다.
        //작성한 Dao를 정의
        abstract fun bookInfoDao(): BookDao
    }
    companion object {
        private var instance: com.bookmark.presentation.data.db.DataBases.BookMarkDatabase? = null

        @Synchronized
        fun getInstance(context: Context): _root_ide_package_.com.bookmark.presentation.data.db.DataBases.BookMarkDatabase? {
            if (_root_ide_package_.com.bookmark.presentation.data.db.DataBases.Companion.instance == null) {
                _root_ide_package_.com.bookmark.presentation.data.db.DataBases.Companion.instance = Room.databaseBuilder(
                    context.applicationContext,
                    _root_ide_package_.com.bookmark.presentation.data.db.DataBases.BookMarkDatabase::class.java, "book_database"
                )
                    .setQueryCallback({ sqlQuery, bindArgs ->
                        println("SQL Query: $sqlQuery SQL Args: $bindArgs")
                    }, Executors.newSingleThreadExecutor())
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return _root_ide_package_.com.bookmark.presentation.data.db.DataBases.Companion.instance
        }
    }
}