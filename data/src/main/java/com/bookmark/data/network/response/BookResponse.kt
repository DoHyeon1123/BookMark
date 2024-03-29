package com.bookmark.data.network.response

import com.bookmark.domain.model.book.Document
import com.bookmark.domain.model.book.Meta

data class BookResponse(
    val meta : Meta,
    val documents : List<Document>
)
