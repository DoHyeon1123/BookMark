package com.bookmark.data.datasource

import com.bookmark.data.mapper.UserMapper
import com.bookmark.domain.model.book.BookType
import com.bookmark.domain.model.profile.User
import com.bookmark.domain.usecase.main.books.SearchBooks
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class AuthDataSource @Inject constructor(
){
    /*private val mapper = UserMapper()
    suspend fun getUserInfo(params : SearchBooks.Params) : User {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.getReference("users")

        
        return mapper
    }

    suspend fun updateUserInfo(type : BookType) : User {
        return mapper
    }

    suspend fun deleteBook(id : String) : User {
        return mapper
    }*/
}