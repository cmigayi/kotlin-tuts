package com.example.kotlinmvvmdatabindingmovieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmvvmdatabindingmovieapp.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private var movieRepository: MovieRepository): ViewModel() {
    init {
        fetchMovies()
    }
    val movies: LiveData<List<Movie>> get() = movieRepository.movies
    fun getError(): LiveData<String> = movieRepository.error

    private fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO)  {
            movieRepository.fetchMovies()
        }
    }
}