package com.bookmark.presentation.features.club.adapter

import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseListAdapter
import com.bookmark.presentation.databinding.ItemSearchResultBinding
import com.bumptech.glide.Glide

class ClubAdapter(private val listener : CallBack) :  BaseListAdapter<Book, ItemSearchResultBinding>(
    R.layout.item_search_result,
    ClubDiffUtilCallback ){

    interface CallBack{
        fun addBook(info : Book)
    }

    override fun action(item: Book, binding: ItemSearchResultBinding) {
        binding.info = item

        Glide.with(binding.ivThumbnail)
            .load(item.image)
            .centerCrop()
            .error(R.drawable.ic_book)
            .into(binding.ivThumbnail)

        binding.root.setOnClickListener {
            listener.addBook(item)
        }
    }
}