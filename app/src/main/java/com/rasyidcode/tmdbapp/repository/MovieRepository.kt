package com.rasyidcode.tmdbapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.rasyidcode.tmdbapp.database.MovieDatabase
import com.rasyidcode.tmdbapp.database.movie.MovieDao
import com.rasyidcode.tmdbapp.database.movie.MovieFetchType
import com.rasyidcode.tmdbapp.database.movie.asMovieDomain
import com.rasyidcode.tmdbapp.domain.Movie
import com.rasyidcode.tmdbapp.network.MovieApiService
import com.rasyidcode.tmdbapp.network.movie.asMoviesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao
) {

    val moviesPopular: LiveData<List<Movie>> = movieDao
        .getMoviesByFetchType(MovieFetchType.POPULAR).map {
            it.asMovieDomain()
        }

    val moviesNowPlaying: LiveData<List<Movie>> = movieDao
        .getMoviesByFetchType(MovieFetchType.NOW_PLAYING).map {
            it.asMovieDomain()
        }

    val moviesTopRated: LiveData<List<Movie>> = movieDao
        .getMoviesByFetchType(MovieFetchType.TOP_RATED).map {
            it.asMovieDomain()
        }

    val moviesUpcoming: LiveData<List<Movie>> = movieDao
        .getMoviesByFetchType(MovieFetchType.UPCOMING).map {
            it.asMovieDomain()
        }

    suspend fun fetchNowPlaying(page: Int = 1) = withContext(Dispatchers.IO) {
        val movies = movieApiService.getNowPlaying(page)

        movieDao.insertAll(
            movies.results.asMoviesEntity(MovieFetchType.NOW_PLAYING)
        )
    }

    suspend fun fetchPopular(page: Int = 1) = withContext(Dispatchers.IO) {
        val movies = movieApiService.getPopular(page)

        movieDao.insertAll(
            movies.results.asMoviesEntity(MovieFetchType.POPULAR)
        )
    }

    suspend fun fetchTopRated(page: Int = 1) = withContext(Dispatchers.IO) {
        val movies = movieApiService.getTopRated(page)

        movieDao.insertAll(
            movies.results.asMoviesEntity(MovieFetchType.TOP_RATED)
        )
    }

    suspend fun fetchUpcoming(page: Int = 1) = withContext(Dispatchers.IO) {
        val movies = movieApiService.getUpcoming(page)

        movieDao.insertAll(
            movies.results.asMoviesEntity(MovieFetchType.UPCOMING)
        )
    }

}