package com.example.bookmark.view.features.list

import androidx.fragment.app.Fragment
import com.example.bookmark.databinding.FragmentListBinding
import com.example.bookmark.view.features.base.BaseFragment

class ListFragment : BaseFragment<FragmentListBinding,ListViewModel>() {
    override val viewModel : ListViewModel by viewModels()
}