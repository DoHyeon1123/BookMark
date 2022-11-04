package com.example.bookmark.view.features.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment(){
    protected abstract val viewModel : VM
}