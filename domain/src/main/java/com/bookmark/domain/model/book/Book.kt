package com.bookmark.domain.model.book

data class Book(
    var id : String,
    var title : String,
    var image : String,
    var author : String,
    var content : String,
    var url : String,
    val reading_date : String
)
