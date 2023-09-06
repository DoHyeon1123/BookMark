package com.bookmark.presentation.adapter

import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseListAdapter
import com.bookmark.presentation.databinding.ItemLibraryBinding
import com.bumptech.glide.Glide

class LibraryAdapter() :  BaseListAdapter<Book, ItemLibraryBinding>(
    R.layout.item_library,
    LibraryDiffUtilCallback ){
    override fun action(item: Book, binding: ItemLibraryBinding) {
        //binding.info = item

        Glide.with(binding.ivThumbnail)
            .load(item.image)
            .centerCrop()
            .error(R.drawable.img_book)
            .into(binding.ivThumbnail)


    }
}