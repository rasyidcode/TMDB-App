package com.rasyidcode.tmdbapp.network

import com.rasyidcode.tmdbapp.network.movie.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int
    ): MovieListResponse

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int
    ): MovieListResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int
    ): MovieListResponse

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("page") page: Int
    ): MovieListResponse

}