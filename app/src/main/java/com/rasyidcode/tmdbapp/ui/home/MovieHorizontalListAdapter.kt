package com.rasyidcode.tmdbapp.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rasyidcode.tmdbapp.databinding.ItemMovieCardBinding
import com.rasyidcode.tmdbapp.domain.Movie

class MovieHorizontalListAdapter :
    ListAdapter<Movie, MovieHorizontalListAdapter.MovieHorizontalListViewHolder>(DiffCallback) {

    class MovieHorizontalListViewHolder(
        private val binding: ItemMovieCardBinding
    ) : ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHorizontalListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MovieHorizontalListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

}