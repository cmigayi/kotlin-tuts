package com.example.kotlincorroutinespopularmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincorroutinespopularmovies.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    init {
        fetchPopularMovies()
    }
    val popularMovies: LiveData<List<Movie>>
    get() = movieRepository.movies
    fun getError(): LiveData<String> = movieRepository.error

    private fun fetchPopularMovies() {
        viewModelScope.launch(Dispatchers.IO)  {
            movieRepository.fetchMovies()
        }
    }
}