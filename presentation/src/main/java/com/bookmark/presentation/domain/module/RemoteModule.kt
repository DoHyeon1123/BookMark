package com.bookmark.presentation.domain.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Singleton
    @Provides
    fun provideBookInfoRemote(retrofit: Retrofit): com.bookmark.presentation.data.api.remote.BookInfoRemote =
        com.bookmark.presentation.data.api.remote.BookInfoRemote(retrofit.create(com.bookmark.presentation.data.api.service.BookInfoApi::class.java))
}