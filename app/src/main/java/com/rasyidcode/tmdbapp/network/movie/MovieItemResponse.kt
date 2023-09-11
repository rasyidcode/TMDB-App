package com.rasyidcode.tmdbapp.network.movie

import com.rasyidcode.tmdbapp.database.movie.MovieEntity
import com.rasyidcode.tmdbapp.database.movie.MovieFetchType
import com.squareup.moshi.Json

data class MovieItemResponse(
    val id: Int? = null,
    @Json(name="original_title")
    val originalTitle: String? = null,
    val title: String? = null,
    val overview: String? = null,
    @Json(name="poster_path")
    val posterPath: String? = null,
    @Json(name="backdrop_path")
    val backdropPath: String? = null,
    @Json(name="genre_ids")
    val genreIds: List<Int?>? = null,
    val adult: Boolean? = null,
    val popularity: Double? = null,
    @Json(name="original_language")
    val originalLanguage: String? = null,
    val video: Boolean? = null,
    @Json(name="release_date")
    val releaseDate: String? = null,
    @Json(name="vote_average")
    val voteAverage: Double? = null,
    @Json(name="vote_count")
    val voteCount: Int? = null
)

fun List<MovieItemResponse?>?.asMoviesEntity(fetchType: MovieFetchType?): List<MovieEntity?>? = this?.map {
    MovieEntity(
        id = null,
        movieId = it?.id,
        title = it?.title,
        originalTitle = it?.originalTitle,
        overview = it?.overview,
        posterPath = it?.posterPath,
        backdropPath = it?.backdropPath,
        genreIds = it?.genreIds?.joinToString(),
        adult = it?.adult,
        popularity = it?.popularity,
        video = it?.video,
        originalLanguage = it?.originalLanguage,
        releaseDate = it?.releaseDate,
        voteAverage = it?.voteAverage,
        voteCount = it?.voteCount,
        fetchType = fetchType
    )
}