package com.bookmark.domain.usecase.profile.library

import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class DeleteBookInLibrary @Inject constructor(private val repository : BookRepository) {
    fun invoke() {}
}