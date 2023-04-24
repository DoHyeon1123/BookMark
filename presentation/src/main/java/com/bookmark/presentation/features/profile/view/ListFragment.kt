package com.bookmark.presentation.features.profile.view

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.base.BaseFragment
import com.bookmark.presentation.databinding.FragmentListBinding
import com.bookmark.presentation.features.profile.adapter.LibraryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(), LibraryAdapter.CallBack {
    override val viewModel : ListViewModel by viewModels()
    private val adapter = LibraryAdapter(this)
    override fun onStart() {
        super.onStart()
        //viewModel.getBooksInLibrary()
        //binding.rvBookList.adapter = adapter
        binding.rvBookList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
    }

    override fun observerViewModel() {
        with(viewModel){
            list.observe(
                viewLifecycleOwner,
                Observer<List<Book>> {
                    Log.e("LibraryFragment", it.toString())
                    //adapter.submitList(it)
                }
            )
        }
    }

    override fun addComment(bookId: String) {
        //val action = ListFragmentDirections.actionListFragmentToCommentFragment(bookId)
        //findNavController().navigate(action)
    }
}