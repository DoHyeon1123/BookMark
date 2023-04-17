package com.bookmark.presentation.features.home.adapter

import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseListAdapter
import com.bookmark.presentation.databinding.ItemCommentBinding
import com.bookmark.presentation.features.comment.adapter.CommentDiffUtilCallback
import org.w3c.dom.Comment

class HomeAdapter(private val listener : CallBack) :  BaseListAdapter<Comment, ItemCommentBinding>(
    R.layout.item_comment,
    CommentDiffUtilCallback ){

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