package com.example.bookmark.presentation.features.library

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmark.databinding.FragmentListBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseFragment
import com.example.bookmark.presentation.features.library.adapter.LibraryAdapter

class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {
    override val viewModel : ListViewModel by viewModels()
    private val adapter = LibraryAdapter()
    override fun onStart() {
        super.onStart()
        viewModel.getBooksInLibrary()
        mBinding.rvBookList.adapter = adapter
        mBinding.rvBookList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
    }

    override fun observerViewModel() {
        with(viewModel){
            list.observe(
                viewLifecycleOwner,
                Observer<List<Book>> {
                    Log.e("LibraryFragment", it.toString())
                    adapter.submitList(it)
                }
            )
        }
    }
}