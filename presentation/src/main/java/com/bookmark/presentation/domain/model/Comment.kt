package com.bookmark.presentation.domain.model

data class Comment(
    var comment : String,
    var dateTime : String,
    var bookId : String,
    var id : Int
)
