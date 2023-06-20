package com.bookmark.presentation.features.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.R
import com.bookmark.presentation.base.BaseFragment
import com.bookmark.presentation.databinding.FragmentHomeBinding
import com.bookmark.presentation.features.home.adapter.HomeAdapter
import com.bookmark.presentation.features.home.state.GetBooksState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(), HomeAdapter.CallBack {
    private val bookAdapter = HomeAdapter(this)
    override val viewModel: HomeViewModel by viewModels()
    //private val args: CommentFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvBookList.adapter = bookAdapter
        mBinding.rvBookList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        viewModel.searchBook()
    }
    override fun observerViewModel() {
        mBinding.btnSearch.setOnClickListener {
            viewModel.searchBook()
        }
        collectBooksInfo()
    }

    override fun deleteComment(info: Book) {
        TODO("Not yet implemented")
    }

    private fun collectBooksInfo() {
        with(viewModel) {
            lifecycleScope.launch {
                getBooksState.collect { state ->
                    if (!state.isLoading) {
                        bookAdapter.submitList(state.bookList)
                    }
                }
            }
        }
    }
}