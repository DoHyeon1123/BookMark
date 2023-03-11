package com.bookmark.presentation.presentation.features.comment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.bookmark.domain.model.Comment

object CommentDiffUtilCallback : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
}