package com.example.bookmark.presentation.features.main

import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.bookmark.R
import com.example.bookmark.databinding.ActivityMainBinding
import com.example.bookmark.presentation.features.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(){
    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        initNavigation()
    }

    private fun initNavigation() {
        NavigationUI.setupWithNavController(mBinding.navBar, findNavController(R.id.nav_host_fragment_container))
    }

}