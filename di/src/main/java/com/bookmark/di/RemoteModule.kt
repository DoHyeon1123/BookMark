package com.bookmark.di

import com.bookmark.data.network.remote.BookRemote
import com.bookmark.data.network.service.BookInfoApi
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
    fun provideBookInfoRemote(@RemoteRetrofit retrofit: Retrofit): BookRemote =
        BookRemote(retrofit.create(BookInfoApi::class.java))


}