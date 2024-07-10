package com.example.testproject.di

import com.example.testproject.network.PostsService
import com.example.testproject.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun loggingInterceptor(
    ): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    @Provides
    fun provideRetrofit(
        interceptor: HttpLoggingInterceptor
    ): Retrofit{
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        val client = OkHttpClient()
        val clientBuilder: OkHttpClient.Builder =
            client.newBuilder().addInterceptor(interceptor)
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientBuilder.build())
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Provides
    fun providePostsService(
        retrofit: Retrofit
    ): PostsService {
        return RetrofitInstance.getInstance().create(PostsService::class.java)
    }
}
