package com.example.bookmark.presentation.features.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmark.databinding.FragmentHomeBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseFragment
import com.example.bookmark.presentation.features.home.adapter.HomeAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()
    val adapter = HomeAdapter()
    override fun onStart() {
        super.onStart()
        mBinding.rvBookList.adapter = adapter
        mBinding.rvBookList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun observerViewModel() {
        Log.e("HomeFragment","실행됨")
        viewModel.searchBooks()

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
}