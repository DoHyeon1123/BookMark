package com.bookmark.presentation.adapter

import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseListAdapter
import com.bookmark.presentation.databinding.ItemSearchResultBinding
import com.bumptech.glide.Glide


class BookAdapter() :  BaseListAdapter<Book, ItemSearchResultBinding>(
    R.layout.item_rcmd_book,
    BookInfoDiffUtilCallback
){

    interface CallBack {
        fun deleteComment(info: Book)
    }

    override fun action(item: Book, binding: ItemSearchResultBinding) {
        binding.info = item
        Glide.with(binding.ivThumbnail)
            .load(item.image)
            .centerCrop()
            //.error()
            .into(binding.ivThumbnail)
    }
}