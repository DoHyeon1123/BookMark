package com.bookmark.presentation.presentation.features.home.adapter

import com.bumptech.glide.Glide
import com.example.bookmark.R
import com.example.bookmark.databinding.ItemSearchResultBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseListAdapter

class HomeAdapter(private val listener : CallBack) :  BaseListAdapter<Book,ItemSearchResultBinding>(R.layout.item_search_result,HomeDiffUtilCallback ){

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