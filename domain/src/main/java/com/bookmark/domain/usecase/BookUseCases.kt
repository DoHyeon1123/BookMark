package com.bookmark.domain.usecase

import com.bookmark.domain.model.book.Book
import com.bookmark.domain.usecase.club.*
import com.bookmark.domain.usecase.club.feed.*
import com.bookmark.domain.usecase.club.member.AddMember
import com.bookmark.domain.usecase.club.member.DeleteMember
import com.bookmark.domain.usecase.club.member.GetMembers
import com.bookmark.domain.usecase.club.member.UpdateMember
import com.bookmark.domain.usecase.main.books.GetBooks
import com.bookmark.domain.usecase.main.books.SearchBooks
import com.bookmark.domain.usecase.profile.GetProfileInfo
import com.bookmark.domain.usecase.profile.UpdateProfileInfo
import com.bookmark.domain.usecase.profile.goal.AddReadingGoal
import com.bookmark.domain.usecase.profile.goal.DeleteReadingGoal
import com.bookmark.domain.usecase.profile.goal.GetReadingGoals
import com.bookmark.domain.usecase.profile.goal.UpdateReadingGoal
import com.bookmark.domain.usecase.profile.library.AddBookInLibrary
import com.bookmark.domain.usecase.profile.library.DeleteBookInLibrary
import com.bookmark.domain.usecase.profile.library.GetLibraryInfo
import com.bookmark.domain.usecase.profile.library.comment.AddComment
import com.bookmark.domain.usecase.profile.library.comment.DeleteComment
import com.bookmark.domain.usecase.profile.library.comment.GetComments
import com.bookmark.domain.usecase.profile.library.comment.UpdateComment
import kotlinx.coroutines.flow.Flow

data class BookUseCases(

    // Club
    // 피드 기능 관련
    val getFeeds: GetFeeds,
    val addFeed : AddFeed,
    val updateFeed: UpdateFeed,
    val deleteFeed : DeleteFeed,
    val shareFeed: ShareFeed,

    // 클럽 멤버 기능 관련
    val getMembers: GetMembers,
    val addMember: AddMember,
    val updateMember: UpdateMember,
    val deleteMember: DeleteMember,

    val getAllClubs: GetAllClubs,
    val getClub: GetClub,
    val addClub: AddClub,
    val updateClub: UpdateClub,
    val deleteClub:  DeleteClub,

    // Main
    // 책 정보
    val getBooks: GetBooks,
    val searchBooks: SearchBooks,

    // Profile
    // 내 프로필 기능 관련
    val getProfileInfo: GetProfileInfo,
    val updateProfileInfo: UpdateProfileInfo,

    // 목표 설정 기능 관련
    val getReadingGoal: GetReadingGoals,
    val addReadingGoal: AddReadingGoal,
    val updateReadingGoal: UpdateReadingGoal,
    val deleteReadingGoal: DeleteReadingGoal,

    // 나의 서재 기능 관련
    val getBookInLibrary: GetLibraryInfo,
    val addBookInLibrary: AddBookInLibrary,
    val deleteBookInLibrary: DeleteBookInLibrary,

    // 코멘트 기능 관련
    val getComments: GetComments,
    val addComment: AddComment,
    val updateComment: UpdateComment,
    val deleteComment: DeleteComment

)
