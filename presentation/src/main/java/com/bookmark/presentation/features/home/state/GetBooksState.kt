package com.bookmark.presentation.features.home.state

import com.bookmark.domain.model.book.Book

data class GetBooksState (
    val isLoading : Boolean = false,
    val query : String = "",
    var bookList : List<Book> = emptyList(),
    )
