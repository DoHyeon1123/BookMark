package com.example.bookmark.presentation.features.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.bookmark.R
import com.example.bookmark.presentation.features.main.MainActivity
import java.lang.reflect.ParameterizedType
import java.util.*
import com.example.bookmark.BR

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment(){
    protected lateinit var mBinding: VB
    private lateinit var mViewModel: VM
    protected abstract val viewModel: VM

    protected var savedInstanceState: Bundle? = null

    protected abstract fun observerViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            layoutRes(),
            container, false
        )!!
        return mBinding.root
    }

    @LayoutRes
    private fun layoutRes(): Int {
        val split =
            (
                    (Objects.requireNonNull(javaClass.genericSuperclass) as ParameterizedType)
                        .actualTypeArguments[0] as Class<*>
                    )
                .simpleName.replace("Binding$".toRegex(), "")
                .split("(?<=.)(?=\\p{Upper})".toRegex())
                .dropLastWhile { it.isEmpty() }.toTypedArray()

        val name = StringBuilder()

        for (i in split.indices) {
            name.append(split[i].lowercase(Locale.ROOT))
            if (i != split.size - 1)
                name.append("_")
        }

        try {
            return R.layout::class.java.getField(name.toString()).getInt(R.layout::class.java)
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }

        return 0
    }
    private fun setUp() {
        mViewModel = if (::mViewModel.isInitialized) mViewModel else viewModel
        mBinding.setVariable(BR.vm, mViewModel)
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()
    }

}