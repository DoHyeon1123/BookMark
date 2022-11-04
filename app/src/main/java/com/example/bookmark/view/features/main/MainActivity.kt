package com.example.bookmark.view.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import com.example.bookmark.R
import com.example.bookmark.databinding.ActivityMainBinding
import com.example.bookmark.view.features.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(){
    fun setNavVisible(demand: Boolean) {
        mBinding.mainBottomNav.isInvisible = demand
    }

    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }
}