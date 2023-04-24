package com.bookmark.presentation.features.comment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bookmark.domain.model.profile.Comment

object ClubDiffUtilCallback : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
}