package com.bookmark.presentation.features.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.R
import com.bookmark.presentation.databinding.FragmentHomeBinding
import com.bookmark.presentation.features.home.adapter.HomeAdapter
import com.bookmark.presentation.features.home.state.GetBooksState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.CallBack {
    private val viewModel: HomeViewModel by viewModels()
    lateinit var binding : FragmentHomeBinding
    private val bookAdapter = HomeAdapter(this)
    private lateinit var getBooksState : GetBooksState
    //private val args: CommentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        binding.rvBookList.adapter = bookAdapter
        binding.rvBookList.layoutManager =
            LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        getBooksState = viewModel.getBooksState.value

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerViewModel()
    }
    private fun observerViewModel() {
        binding.btnSearch.setOnClickListener {
            viewModel.searchBook(getBooksState.query)
        }
        bookAdapter.submitList(getBooksState.bookList)
    }

    override fun deleteComment(info: Book) {
        TODO("Not yet implemented")
    }
}