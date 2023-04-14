package com.bookmark.domain.usecase.profile.library.comment

import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class DeleteComment @Inject constructor(private val repository : BookRepository) {
    fun invoke() {}
}