package com.example.bookmark.view.features.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bookmark.databinding.FragmentHomeBinding
import com.example.bookmark.view.features.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }
}