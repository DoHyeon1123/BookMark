package com.bookmark.presentation.features.home.state

import com.bookmark.domain.model.book.Book

sealed class HomeUiState {
    data class Success(
        val searchText : String = "",
        val bookList : List<Book>
    )
    data class Error(
        val exception : Throwable
    )
}
