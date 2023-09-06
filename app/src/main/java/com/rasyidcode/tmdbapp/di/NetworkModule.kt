package com.rasyidcode.tmdbapp.di

import com.rasyidcode.tmdbapp.BuildConfig
import com.rasyidcode.tmdbapp.network.MovieApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                val originalHttpUrl = it.request().url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build()
                request.url(url)

                return@addInterceptor it.proceed(request.build())
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }

}