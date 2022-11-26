package com.example.bookmark.presentation.features.library

import androidx.fragment.app.viewModels
import com.example.bookmark.databinding.FragmentListBinding
import com.example.bookmark.presentation.base.BaseFragment

class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {
    override val viewModel : ListViewModel by viewModels()
    override fun observerViewModel() {

    }
}