package com.rasyidcode.tmdbapp.domain

data class Movie(
    val id: Int? = null,
    val title: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val genreIds: String? = null,
    val adult: Boolean? = null,
    val popularity: Double? = null,
    val originalLanguage: String? = null,
    val video: Boolean? = null,
    val releaseDate: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null
)
