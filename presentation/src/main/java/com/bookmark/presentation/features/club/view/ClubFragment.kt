package com.bookmark.presentation.features.club.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmark.domain.model.book.Book
import com.bookmark.presentation.R
import com.bookmark.presentation.databinding.FragmentHomeBinding
import com.bookmark.presentation.databinding.FragmentTimeBinding
import com.bookmark.presentation.features.club.adapter.ClubAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClubFragment : Fragment(), ClubAdapter.CallBack{
    private val viewModel: ClubViewModel by viewModels()
    private lateinit var binding : FragmentTimeBinding
    private val adapter = ClubAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_time,
            container,
            false
        )

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observerViewModel()
    }

    private fun observerViewModel() {
        Log.e("HomeFragment","실행됨")
    }

    override fun addBook(info: Book) {
        viewModel.addBookInLibrary(info)
    }
}