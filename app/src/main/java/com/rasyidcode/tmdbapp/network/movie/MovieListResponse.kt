package com.rasyidcode.tmdbapp.network.movie

import com.squareup.moshi.Json

data class MovieListResponse(

    @Json(name="page")
	val page: Int? = null,

    @Json(name="total_pages")
	val totalPages: Int? = null,

    @Json(name="results")
	val results: List<MovieItemResponse?>? = null,

    @Json(name="total_results")
	val totalResults: Int? = null
)