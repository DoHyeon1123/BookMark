package com.example.bookmark.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookmark.data.db.cache.BookInfoCache

class DataBases {
    @Database(entities = [BookEntity::class], version = 1)//version은 구조 변경 시 구버전과 구분할 수 있도록 해준다.

    abstract class StudentDatabase: RoomDatabase() {
        //RoomDatabase()를 상속받는 DataBase 추상 클래스를 작성한다.
        //작성한 Dao를 정의
        abstract fun studentDao(): BookInfoCache
    }
    companion object {
        private var instance: StudentDatabase? = null

        @Synchronized
        fun getInstance(context: Context): StudentDatabase? {
            if (instance == null) {
                synchronized(StudentDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "book-database"//사용할 데이터베이스 이름
                    ).build()
                }
            }
            return instance
        }
    }
}