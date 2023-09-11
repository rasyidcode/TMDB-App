package com.rasyidcode.tmdbapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rasyidcode.tmdbapp.domain.Movie
import com.rasyidcode.tmdbapp.ui.adapters.MovieListAdapter

private const val TAG = "RecyclerViewBindingAdapters"

@BindingAdapter("movieList")
fun bindNowPlayingList(recyclerView: RecyclerView, data: List<Movie>?) {
    data?.let {
        val adapter = recyclerView.adapter as MovieListAdapter
        adapter.submitList(it)
    }
}