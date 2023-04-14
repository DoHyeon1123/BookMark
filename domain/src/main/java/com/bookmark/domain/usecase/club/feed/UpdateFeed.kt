package com.bookmark.domain.usecase.club.feed

import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class UpdateFeed @Inject constructor(private val repository : BookRepository) {
    fun invoke() {}
}