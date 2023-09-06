package com.rasyidcode.tmdbapp.di

import com.rasyidcode.tmdbapp.database.movie.MovieDao
import com.rasyidcode.tmdbapp.network.MovieApiService
import com.rasyidcode.tmdbapp.repository.MovieRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieApiService: MovieApiService,
        movieDao: MovieDao
    ): MovieRepository {
        return MovieRepository(movieApiService, movieDao)
    }
}