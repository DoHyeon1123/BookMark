package com.example.bookmark.presentation.features.home

import android.util.Log
import androidx.fragment.app.viewModels
import com.example.bookmark.databinding.FragmentHomeBinding
import com.example.bookmark.presentation.features.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun observerViewModel() {
        Log.e("HomeFragment","실행됨")
    }
}