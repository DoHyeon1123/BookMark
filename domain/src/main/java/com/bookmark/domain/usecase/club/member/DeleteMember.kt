package com.bookmark.domain.usecase.club.member

import com.bookmark.domain.repository.BookRepository
import javax.inject.Inject

class DeleteMember @Inject constructor(private val repository : BookRepository) {
    fun invoke() {}
}