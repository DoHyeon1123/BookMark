package com.example.bookmark.presentation.features.home

import androidx.fragment.app.viewModels
import com.example.bookmark.databinding.FragmentHomeBinding
import com.example.bookmark.presentation.features.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }
}