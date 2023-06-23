package com.bookmark.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

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
            .addInterceptor(HeaderInterceptor(Constants.KAKAO_API_KEY))
        return okhttpBuilder.build()
    }

    @RemoteRetrofit
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, @OtherOkHttpClient client : OkHttpClient) : Retrofit {
        return Retrofit
            .Builder()
            .client(client)
            .baseUrl(Constants.KAKAO_API_HOST)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    class HeaderInterceptor constructor(private val token :  String) : Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val token = "KakaoAK $token"
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", token)
                .build()
            return chain.proceed(newRequest)
        }
    }
}