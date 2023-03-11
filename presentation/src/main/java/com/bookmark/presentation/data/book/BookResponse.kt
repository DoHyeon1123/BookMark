package com.bookmark.presentation.data.book

data class BookResponse(
    val meta : com.bookmark.presentation.data.book.Meta,
    val documents : List<com.bookmark.presentation.data.book.Document>
)
