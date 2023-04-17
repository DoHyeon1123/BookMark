package com.bookmark.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var binding: VB // 데이터 바인딩
    abstract val TAG :String // 액티비티 태그
    abstract val layoutRes: Int // 바인딩에 필요한 layout
    abstract val viewModel: VM // 뷰모델

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"onCreate")
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }
}