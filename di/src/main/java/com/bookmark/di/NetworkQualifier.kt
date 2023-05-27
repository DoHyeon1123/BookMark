package com.bookmark.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteRetrofit
annotation class ChatGPTRetrofit
annotation class OtherOkHttpClient
annotation class ChatOkHttpClient