package com.bookmark.di

import com.bookmark.domain.repository.BookRepository
import com.bookmark.domain.usecase.BookUseCases
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
import com.bookmark.domain.usecase.profile.library.InsertBookInLibrary
import com.bookmark.domain.usecase.profile.library.DeleteBookInLibrary
import com.bookmark.domain.usecase.profile.library.SelectBookInLibrary
import com.bookmark.domain.usecase.profile.library.comment.AddComment
import com.bookmark.domain.usecase.profile.library.comment.DeleteComment
import com.bookmark.domain.usecase.profile.library.comment.GetComments
import com.bookmark.domain.usecase.profile.library.comment.UpdateComment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideBookUseCases(repository : BookRepository) : BookUseCases =
        BookUseCases(
            // 피드
            addFeed = AddFeed(repository),
            deleteFeed = DeleteFeed(repository),
            getFeeds = GetFeeds(repository),
            shareFeed = ShareFeed(repository),
            updateFeed = UpdateFeed(repository),

            // 멤버
            addMember = AddMember(repository),
            deleteMember = DeleteMember(repository),
            getMembers = GetMembers(repository),
            updateMember = UpdateMember(repository),

            // 클럽
            addClub = AddClub(repository),
            deleteClub = DeleteClub(repository),
            getAllClubs = GetAllClubs(repository),
            getClub = GetClub(repository),
            updateClub = UpdateClub(repository),

            // 책 정보
            getBooks = GetBooks(repository),
            searchBooks = SearchBooks(repository),

            // 목표
            addReadingGoal = AddReadingGoal(repository),
            deleteReadingGoal = DeleteReadingGoal(repository),
            getReadingGoal = GetReadingGoals(repository),
            updateReadingGoal = UpdateReadingGoal(repository),

            // 코멘트
            addComment = AddComment(repository),
            deleteComment = DeleteComment(repository),
            getComments = GetComments(repository),
            updateComment = UpdateComment(repository),

            // 서재
            addBookInLibrary = InsertBookInLibrary(repository),
            deleteBookInLibrary = DeleteBookInLibrary(repository),
            getBookInLibrary = SelectBookInLibrary(repository),

            // 프로필
            getProfileInfo = GetProfileInfo(repository),
            updateProfileInfo = UpdateProfileInfo(repository),
        )
}