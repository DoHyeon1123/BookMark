package com.bookmark.domain.usecase.profile.library

import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class AddBookInLibrary @Inject constructor(private val repository : BookRepository) {
    fun invoke() {}
}