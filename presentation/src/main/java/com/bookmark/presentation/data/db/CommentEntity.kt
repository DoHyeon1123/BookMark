package com.bookmark.presentation.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Comments")
data class CommentEntity(
    val comment : String,
    val dateTime : String,
    val bookId : String,
    @PrimaryKey(autoGenerate = true) val id : Int
)
