package com.rasyidcode.tmdbapp.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.rasyidcode.tmdbapp.BuildConfig

@BindingAdapter("posterPath")
fun bindMoviePoster(imageView: ImageView, posterPath: String?) {
    posterPath?.let {
        val imageUrl = "${BuildConfig.API_POSTER_BASE_URL}$it"
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri)
    }
}