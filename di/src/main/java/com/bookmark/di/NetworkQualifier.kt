package com.bookmark.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteRetrofit
annotation class OtherOkHttpClient