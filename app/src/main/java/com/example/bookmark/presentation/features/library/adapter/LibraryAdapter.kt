package com.example.bookmark.presentation.features.library.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookmark.R
import com.example.bookmark.databinding.FragmentHomeBinding
import com.example.bookmark.databinding.ItemLibraryBinding
import com.example.bookmark.databinding.ItemSearchResultBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseListAdapter

class LibraryAdapter(private val listener : CallBack) :  BaseListAdapter<Book,ItemLibraryBinding>(R.layout.item_library,LibraryDiffUtilCallback ){
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