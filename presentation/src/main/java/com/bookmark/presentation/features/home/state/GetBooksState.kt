package com.bookmark.presentation.features.home.state

import com.bookmark.domain.model.book.Book

data class GetBooksState (
    var isLoading : Boolean = false,
    var query : String = "",
    var bookList : List<Book> = emptyList(),
    )
