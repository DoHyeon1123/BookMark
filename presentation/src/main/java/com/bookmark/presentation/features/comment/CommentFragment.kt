package com.bookmark.presentation.features.comment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.profile.Comment
import com.bookmark.presentation.R
import com.bookmark.presentation.databinding.FragmentCommentBinding
import com.bookmark.presentation.adapter.BookAdapter
import com.bookmark.presentation.features.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint


class CommentFragment() : Fragment(), BookAdapter.CallBack {
    private val viewModel : HomeViewModel by viewModels()
    private lateinit var binding : FragmentCommentBinding
    private val adapter = BookAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_comment,
            container,
            false
        )
        binding.rvComment.adapter = adapter
        binding.rvComment.layoutManager =
            GridLayoutManager(requireContext(),3)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observerViewModel()
    }
    private fun observerViewModel() {
        binding.btnComment.setOnClickListener{
            //viewModel.addComment(args.bookId)
        }

        with(viewModel){
        }
    }

    override fun deleteComment(info: Book) {
        TODO("Not yet implemented")
    }
}