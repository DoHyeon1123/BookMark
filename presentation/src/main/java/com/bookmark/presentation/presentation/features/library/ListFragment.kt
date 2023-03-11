package com.bookmark.presentation.presentation.features.library

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookmark.databinding.FragmentListBinding
import com.example.bookmark.domain.model.Book
import com.example.bookmark.presentation.base.BaseFragment
import com.example.bookmark.presentation.features.library.adapter.LibraryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(), LibraryAdapter.CallBack {
    override val viewModel : ListViewModel by viewModels()
    private val adapter = LibraryAdapter(this)
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

    override fun addComment(bookId: String) {
        val action = ListFragmentDirections.actionListFragmentToCommentFragment(bookId)
        findNavController().navigate(action)
    }
}