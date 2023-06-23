package com.bookmark.presentation.features.club.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bookmark.domain.model.book.Book

object ClubDiffUtilCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean = oldItem == newItem
}