package com.bookmark.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
class NetworkModule {


    object Constants { //TODO 삭제해야 함 아키텍처 구축 후 위치 이동하기
        const val API_HOST = ""
    }

    //Provides는 인스턴스를 Retrofit OkHttp등의 객체를 제공합니다.
    // Singleton은 싱글톤 객체를 의미합니다.
    @Provides
    fun provideBaseUrl() = Constants.API_HOST

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
        return gsonBuilder.create()
    }

    @OtherOkHttpClient
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okhttpBuilder = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
        return okhttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, @OtherOkHttpClient client : OkHttpClient) : Retrofit {
        return Retrofit
            .Builder()
            .client(client)
            .baseUrl(Constants.API_HOST)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}