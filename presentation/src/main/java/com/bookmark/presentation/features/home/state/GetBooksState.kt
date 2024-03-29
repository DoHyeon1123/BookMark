package com.bookmark.presentation.features.home.state

import com.bookmark.domain.model.book.Book

data class GetBooksState (
    val isLoading : Boolean = true,
    val bookList : List<Book> = emptyList(),
    var error : String = ""
    )
