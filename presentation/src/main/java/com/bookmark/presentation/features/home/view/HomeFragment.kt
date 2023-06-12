package com.bookmark.presentation.features.home.view

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.base.BaseFragment
import com.bookmark.presentation.databinding.FragmentHomeBinding
import com.bookmark.presentation.features.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), HomeAdapter.CallBack {
    override val viewModel: HomeViewModel by viewModels()
    private val bookAdapter = HomeAdapter(this)
    //private val args: CommentFragmentArgs by navArgs()

    private val getBooksState = viewModel.getBooksState.value
    override fun onStart() {
        super.onStart()
        //viewModel.getComment(args.bookId)
        binding.rvBookList.adapter = bookAdapter
        binding.rvBookList.layoutManager =
            LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun observerViewModel() {
        binding.btnSearch.setOnClickListener{
            viewModel.searchBook(getBooksState.query)
        }
        bookAdapter.submitList(getBooksState.bookList)
    }
    override fun deleteComment(info: Book) {

    }
}