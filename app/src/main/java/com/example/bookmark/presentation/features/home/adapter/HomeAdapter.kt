package com.example.bookmark.presentation.features.home.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmark.R
import com.example.bookmark.databinding.FragmentHomeBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseListAdapter

class HomeAdapter :  BaseListAdapter<Book,FragmentHomeBinding>(R.layout.item_search_result,HomeDiffUtilCallback ){
    override fun action(item: Book, binding: FragmentHomeBinding) {

    }
}