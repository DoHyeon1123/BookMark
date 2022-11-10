package com.example.bookmark.presentation.features.main

import androidx.activity.viewModels
import com.example.bookmark.databinding.ActivityMainBinding
import com.example.bookmark.presentation.features.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(){
    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }

}