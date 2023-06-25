package com.bookmark.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "Library")
data class BookEntity(
    val title : String,
    val image : String,
    val contents : String,
    val authors : String,
    val url : String,
    val type : BookType,
    val reading_date : String,
    @PrimaryKey val id : String
)
