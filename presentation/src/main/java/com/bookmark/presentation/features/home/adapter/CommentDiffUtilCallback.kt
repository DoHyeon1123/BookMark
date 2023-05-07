package com.bookmark.presentation.features.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bookmark.domain.model.profile.Comment

object CommentDiffUtilCallback : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
}