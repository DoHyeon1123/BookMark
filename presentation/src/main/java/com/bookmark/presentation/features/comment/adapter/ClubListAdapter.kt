package com.bookmark.presentation.features.comment.adapter

import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseListAdapter
import com.bookmark.presentation.databinding.ItemCommentBinding
import org.w3c.dom.Comment

class ClubListAdapter(private val listener : CallBack) :  BaseListAdapter<Comment, ItemCommentBinding>(
    R.layout.item_comment,
    ClubDiffUtilCallback ){

    interface CallBack{
        fun deleteComment(info : Comment)
    }

    override fun action(item: Comment, binding: ItemCommentBinding) {

        binding.root.setOnClickListener {
            listener.deleteComment(item)
        }
    }
}