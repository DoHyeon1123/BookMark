package com.bookmark.presentation.presentation.features.timer

import androidx.lifecycle.MutableLiveData
import com.example.bookmark.domain.usecase.BookUseCases
import com.example.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimeViewModel  @Inject constructor(
    private val useCases: BookUseCases
): BaseViewModel() {
    val time = MutableLiveData<String>()
}