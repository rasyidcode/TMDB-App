package com.rasyidcode.tmdbapp.database.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rasyidcode.tmdbapp.domain.Movie

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name="movie_id")
    val movieId: Int? = null,
    val title: String? = null,
    @ColumnInfo(name = "original_title")
    val originalTitle: String? = null,
    val overview: String? = null,
    @ColumnInfo(name = "poster_path")
    val posterPath: String? = null,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String? = null,
    @ColumnInfo(name = "genre_ids")
    val genreIds: String? = null,
    val adult: Boolean? = null,
    val popularity: Double? = null,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String? = null,
    val video: Boolean? = null,
    @ColumnInfo(name = "release_date")
    val releaseDate: String? = null,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double? = null,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int? = null,
    @ColumnInfo(name = "fetch_type")
    val fetchType: MovieFetchType? = null
)

enum class MovieFetchType {
    POPULAR, NOW_PLAYING, TOP_RATED, UPCOMING
}

private const val TAG = "MovieEntity"

fun List<MovieEntity?>?.asMovieDomain(): List<Movie>? = this?.map {
    Movie(
        id = it?.id,
        movieId = it?.movieId,
        title = it?.title,
        originalLanguage = it?.originalLanguage,
        originalTitle = it?.originalTitle,
        overview = it?.overview,
        posterPath = it?.posterPath,
        backdropPath = it?.backdropPath,
        genreIds = it?.genreIds,
        adult = it?.adult,
        popularity = it?.popularity,
        video = it?.video,
        releaseDate = it?.releaseDate,
        voteCount = it?.voteCount,
        voteAverage = it?.voteAverage
    )
}
