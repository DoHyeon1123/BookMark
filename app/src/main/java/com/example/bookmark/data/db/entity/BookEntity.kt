package com.example.bookmark.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(
    val title : String,
    val image : String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
