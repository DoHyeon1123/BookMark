package com.example.bookmark.presentation.features.comment

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookmark.databinding.FragmentCommentBinding
import com.example.bookmark.domain.model.Comment
import com.example.bookmark.presentation.base.BaseFragment
import com.example.bookmark.presentation.features.comment.adapter.CommentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentFragment : BaseFragment<FragmentCommentBinding,CommentViewModel>(),CommentAdapter.CallBack {
    override val viewModel: CommentViewModel by viewModels()
    private val adapter = CommentAdapter(this)

    private val args: CommentFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()
        mBinding.rvComment.adapter = adapter
        mBinding.rvComment.layoutManager =LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun observerViewModel() {
        mBinding.btnComment.setOnClickListener{
            viewModel.addComment(args.bookId)
        }
    }

    override fun deleteComment(info: Comment) {
        viewModel.deleteComment(info.bookId, info.id)
    }
}