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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.adapter.BookAdapter
import com.bookmark.presentation.databinding.FragmentProfileBinding
import com.bookmark.presentation.adapter.LibraryAdapter
import com.bookmark.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val viewModel : ProfileViewModel by viewModels()
    private val adapter = BookAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvBookList.adapter = adapter
        mBinding.rvBookList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        selectBookInLibrary()
    }
    override fun observerViewModel() {
        selectBookInLibrary()
    }

    private fun selectBookInLibrary(){
        with(viewModel) {
            lifecycleScope.launch {
                profileUiState.collect { state ->
                    adapter.submitList(state.bookList)
                }
            }
        }
    }

}