package com.bookmark.domain.model.book

data class Meta(
    val is_end : Boolean = true,
    val pageable_count : Int = -1,
    val total_count : Int = -1
)
