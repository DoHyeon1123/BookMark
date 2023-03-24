package com.bookmark.presentation.features.library.adapter

import com.bumptech.glide.Glide
import com.example.bookmark.R
import com.example.bookmark.databinding.ItemLibraryBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseListAdapter

class LibraryAdapter(private val listener : CallBack) :  BaseListAdapter<Book,ItemLibraryBinding>(R.layout.item_library,
    LibraryDiffUtilCallback ){
    interface CallBack{
        fun addComment(bookId : String)
    }
    override fun action(item: Book, binding: ItemLibraryBinding) {
        binding.info = item

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