package com.bookmark.presentation.features.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.book.BookType
import com.bookmark.domain.usecase.BookUseCases
import com.bookmark.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases : BookUseCases
    ) : BaseViewModel() {
    //val bookType : MutableLiveData<>

    private val _profileUiState = MutableStateFlow(ProfileUiState())
    val profileUiState: StateFlow<ProfileUiState> = _profileUiState

    //TODO User 관련 data Logic 작성

    fun selectBookInLibrary() {
        viewModelScope.launch {
            useCases.selectBookInLibrary(
                BookType.NEW
            ).onSuccess { flow ->
                flow.onStart {
                    _profileUiState.emit(
                        ProfileUiState(
                            isLoading = true
                        )
                    )
                }.collectLatest { data ->
                    _profileUiState.emit(
                        ProfileUiState(
                            bookList = data,
                            isLoading = false
                        )
                    )
                    Log.d("ProfileViewModel_selectBookInLibrary()", data.toString())
                }
            }.onFailure { err ->
                _profileUiState.emit(
                    ProfileUiState(
                        error = "목록을 불러오는 데에 실패했습니다",
                        isLoading = false
                    )
                )
            }
        }
    }

}