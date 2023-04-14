package com.bookmark.domain.usecase.profile

import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class UpdateProfileInfo @Inject constructor(private val repository : BookRepository) {
    fun invoke() {}
}