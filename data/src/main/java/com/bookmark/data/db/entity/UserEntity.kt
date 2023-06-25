package com.bookmark.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "User")
data class UserEntity(
    val name : String,
    val image : String,
    val description : String,
    val type : UserType,
    @PrimaryKey val id : Int
)
