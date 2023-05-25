package com.bookmark.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {


    object Constants { //TODO 삭제해야 함 아키텍처 구축 후 위치 이동하기
        const val API_HOST = ""
    }

    //Provides는 인스턴스를 Retrofit OkHttp등의 객체를 제공합니다.
    // Singleton은 싱글톤 객체를 의미합니다.
    @Provides
    fun provideBaseUrl() = Constants.API_HOST

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient{

        //loggingIterceptor를 사용해 Body 레벨 Response를 logging합니다.
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(provideBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /*@Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): com.bookmark.presentation.data.api.service.BookInfoApi {
        return retrofit.create(com.bookmark.presentation.data.api.service.BookInfoApi::class.java)
    }*/
}