package com.bookmark.presentation.features.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bookmark.presentation.base.BaseActivity
import com.bookmark.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val TAG: String
        get() = TODO("Not yet implemented")
    override val layoutRes: Int
        get() = TODO("Not yet implemented")
    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(com.bookmark.presentation.R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navBar
            .setupWithNavController(navController)
    }
}