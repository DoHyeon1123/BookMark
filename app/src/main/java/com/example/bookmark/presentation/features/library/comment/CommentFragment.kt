package com.example.bookmark.presentation.features.library.comment

import androidx.fragment.app.viewModels
import com.example.bookmark.databinding.FragmentCommentBinding
import com.example.bookmark.presentation.base.BaseFragment

class CommentFragment : BaseFragment<FragmentCommentBinding,CommentViewModel>() {
    override val viewModel: CommentViewModel by viewModels()

    override fun onStart() {
        super.onStart()
    }

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }
}