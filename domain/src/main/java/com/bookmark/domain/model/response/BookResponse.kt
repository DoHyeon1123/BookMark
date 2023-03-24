package com.bookmark.domain.model.response

data class BookResponse(
    val meta : com.bookmark.presentation.data.book.Meta,
    val documents : List<com.bookmark.presentation.data.book.Document>
)
