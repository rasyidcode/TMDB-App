package com.rasyidcode.tmdbapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.rasyidcode.tmdbapp.domain.Movie
import com.rasyidcode.tmdbapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val topRatedMovies: LiveData<List<Movie>> = movieRepository.moviesTopRated.map { it.take(10) }

    val upcomingMovies: LiveData<List<Movie>> = movieRepository.moviesUpcoming.map { it.take(10) }

    val nowPlayingMovies: LiveData<List<Movie>> = movieRepository.moviesNowPlaying.map { it.take(10) }

    val popularMovies: LiveData<List<Movie>> = movieRepository.moviesPopular.map { it.take(10) }

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    init {
        fetchData()
    }

    private fun fetchData() = viewModelScope.launch {
        try {
            _isLoading.value = true

            async { movieRepository.fetchNowPlaying(1) }.await()
            async { movieRepository.fetchPopular(1) }.await()
            async { movieRepository.fetchUpcoming(1) }.await()
            async { movieRepository.fetchTopRated(1) }.await()

            _isLoading.value = false
        } catch (exception: IOException) {

            _errorMessage.value = exception.message
            _isLoading.value = false
        }
    }

}