package com.bookmark.presentation.features.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.databinding.FragmentListBinding
import com.bookmark.presentation.adapter.LibraryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(), LibraryAdapter.CallBack {
    private val viewModel : ListViewModel by viewModels()
    private lateinit var binding : FragmentListBinding
    private val adapter = LibraryAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel.getBooksInLibrary()
        //binding.rvBookList.adapter = adapter
        binding.rvBookList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observerViewModel()
    }

    private fun observerViewModel() {
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