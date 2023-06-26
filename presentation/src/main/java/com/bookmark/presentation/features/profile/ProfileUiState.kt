package com.bookmark.presentation.features.profile

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.User

data class ProfileUiState(
    val isLoading : Boolean = true,
    val bookList : List<Book> = emptyList(),
    val user : User = User(
        id = -1
    ),
    val error : String = ""
)
