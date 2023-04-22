package com.bookmark.presentation.features.profile.adapter

import com.bookmark.domain.model.Book
import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseListAdapter
import com.bookmark.presentation.databinding.ItemLibraryBinding
import com.bumptech.glide.Glide

class LibraryAdapter(private val listener : CallBack) :  BaseListAdapter<Book, ItemLibraryBinding>(
    R.layout.item_library,
    LibraryDiffUtilCallback ){
    interface CallBack{
        fun addComment(bookId : String)
    }
    override fun action(item: Book, binding: ItemLibraryBinding) {
        //binding.info = item

        Glide.with(binding.ivThumbnail)
            .load(item.image)
            .centerCrop()
            .error(R.drawable.ic_book)
            .into(binding.ivThumbnail)

        binding.root.setOnClickListener {
            listener.addComment(item.id)
        }
    }
}