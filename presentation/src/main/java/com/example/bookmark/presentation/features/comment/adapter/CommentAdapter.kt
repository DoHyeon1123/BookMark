package com.example.bookmark.presentation.features.comment.adapter

import com.bumptech.glide.Glide
import com.example.bookmark.R
import com.example.bookmark.databinding.ItemCommentBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment
import com.example.bookmark.presentation.base.BaseListAdapter

class CommentAdapter(private val listener : CallBack) :  BaseListAdapter<Comment,ItemCommentBinding>(R.layout.item_comment,CommentDiffUtilCallback ){

    interface CallBack{
        fun deleteComment(info : Comment)
    }

    override fun action(item: Comment, binding: ItemCommentBinding) {
        binding.info = item
        binding.root.setOnClickListener {
            listener.deleteComment(item)
        }
    }
}