package com.example.bookmark.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BookInfo")
data class BookEntity(
    val title : String,
    val image : String,
    val contents : String,
    val authors : String,
    val url : String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
