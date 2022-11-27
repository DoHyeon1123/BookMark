package com.example.bookmark.domain.module

import com.example.bookmark.data.api.remote.BookInfoRemote
import com.example.bookmark.data.api.service.BookInfoApi
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
    fun provideBookInfoRemote(retrofit: Retrofit): BookInfoRemote =
        BookInfoRemote(retrofit.create(BookInfoApi::class.java))
}