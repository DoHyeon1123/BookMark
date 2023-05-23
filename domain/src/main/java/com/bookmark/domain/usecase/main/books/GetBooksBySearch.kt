package com.bookmark.domain.usecase.main.books

import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class GetBooksBySearch @Inject constructor(private val repository : BookRepository) {
    fun invoke() {}
}