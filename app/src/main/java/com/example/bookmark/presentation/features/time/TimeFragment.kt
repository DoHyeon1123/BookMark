package com.example.bookmark.presentation.features.time

import androidx.fragment.app.viewModels
import com.example.bookmark.databinding.FragmentTimeBinding
import com.example.bookmark.presentation.features.base.BaseFragment

class TimeFragment : BaseFragment<FragmentTimeBinding,TimeViewModel>() {
    override val viewModel: TimeViewModel by viewModels()

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }
}