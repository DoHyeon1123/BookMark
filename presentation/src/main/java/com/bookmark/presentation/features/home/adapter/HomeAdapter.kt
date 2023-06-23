package com.bookmark.presentation.features.home.adapter

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.Comment
import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseListAdapter
import com.bookmark.presentation.databinding.ItemCommentBinding
import com.bookmark.presentation.databinding.ItemSearchResultBinding
import com.bumptech.glide.Glide
import kotlin.coroutines.coroutineContext


class HomeAdapter(private val listener : CallBack) :  BaseListAdapter<Book, ItemSearchResultBinding>(
    R.layout.item_search_result,
    BookInfoDiffUtilCallback){

    interface CallBack {
        fun deleteComment(info: Book)
    }

    override fun action(item: Book, binding: ItemSearchResultBinding) {
        binding.info = item
        binding.root.setOnClickListener {
            listener.deleteComment(item)
        }
        Glide.with(binding.ivThumbnail)
            .load(item.image)
            .centerCrop()
            //.error()
            .into(binding.ivThumbnail)
    }
}