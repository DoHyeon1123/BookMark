package com.example.bookmark.presentation.features.main

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.bookmark.R
import com.example.bookmark.databinding.ActivityMainBinding
import com.example.bookmark.presentation.features.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(){
    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        Log.e("MainActivity","observerViewModel()")
        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        mBinding.navBar
            .setupWithNavController(navController)
    }

} 