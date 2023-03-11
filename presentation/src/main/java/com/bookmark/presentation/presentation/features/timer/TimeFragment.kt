package com.bookmark.presentation.presentation.features.timer

import android.os.SystemClock
import androidx.fragment.app.viewModels
import com.example.bookmark.databinding.FragmentTimeBinding
import com.example.bookmark.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TimeFragment : BaseFragment<FragmentTimeBinding, TimeViewModel>() {
    override val viewModel: TimeViewModel by viewModels()

    //  뒤로가기 버튼을 누른 시각을 저장하는 속성
    var initTime = 0L
    var pauseTime = 0L
    override fun observerViewModel() {
        mBinding.btnStart.setOnClickListener {
            mBinding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            mBinding.chronometer.start()

            // 버튼 표시 여부 조정
            mBinding.btnStart.isEnabled = false
            mBinding.btnReset.isEnabled = true
            mBinding.btnStop.isEnabled = true
        }

        mBinding.btnStop.setOnClickListener {
            pauseTime = mBinding.chronometer.base - SystemClock.elapsedRealtime()
            mBinding.chronometer.stop()
            mBinding.btnStart.isEnabled = true
            mBinding.btnReset.isEnabled = true
            mBinding.btnStop.isEnabled = false
        }

        mBinding.btnReset.setOnClickListener {
            pauseTime = 0L
            mBinding.chronometer.base = SystemClock.elapsedRealtime()
            mBinding.chronometer.stop()
            mBinding.btnStart.isEnabled = true
            mBinding.btnReset.isEnabled = false
            mBinding.btnStop.isEnabled = false
        }
    }
}