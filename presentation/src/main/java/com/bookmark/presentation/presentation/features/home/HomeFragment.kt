package com.bookmark.presentation.presentation.features.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookmark.databinding.FragmentHomeBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseFragment
import com.example.bookmark.presentation.features.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), HomeAdapter.CallBack{
    override val viewModel: HomeViewModel by viewModels()
    private val adapter = HomeAdapter(this)
    override fun onStart() {
        super.onStart()
        viewModel.searchBooks()
        mBinding.rvBookList.adapter = adapter
        mBinding.rvBookList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun observerViewModel() {
        Log.e("HomeFragment","실행됨")
        mBinding.btnSearch.setOnClickListener {
            Log.e("HomeFragment","검색")
            viewModel.searchBooks()
        }
        with(viewModel) {
            bookList.observe(
                viewLifecycleOwner,
                Observer<List<Book>> {
                    Log.e("LostFoundFragment", it.toString())
                    adapter.submitList(it)
                }
            )
        }
    }

    override fun addBook(info: Book) {
        viewModel.addBookInLibrary(info)
    }
}