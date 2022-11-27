package com.example.bookmark.domain.model

data class Comment(
    val comment : String,
    val dateTime : String,
    val bookId : String,
    val id : Int
)
