package com.bookmark.presentation.features.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.databinding.FragmentProfileBinding
import com.bookmark.presentation.adapter.LibraryAdapter
import com.bookmark.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(), LibraryAdapter.CallBack {
    override val viewModel : ProfileViewModel by viewModels()
    private val adapter = LibraryAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvBookList.adapter = adapter
        mBinding.rvBookList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
    override fun observerViewModel() {
        mBinding.rvBookList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
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