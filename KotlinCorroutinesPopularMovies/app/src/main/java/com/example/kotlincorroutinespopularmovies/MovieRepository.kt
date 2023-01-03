package com.example.kotlincorroutinespopularmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlincorroutinespopularmovies.model.Movie

class MovieRepository(val movieService: MovieService) {
    private val apiKey = "5fc17697797b23a50431f88e3634466f"
    private val movieLiveData = MutableLiveData<List<Movie>>()
    private val errorLiveData = MutableLiveData<String>()
    val movies: LiveData<List<Movie>> get() = movieLiveData
    val error: LiveData<String> get() = errorLiveData

    suspend fun fetchMovies() {
        try {
            val popularMovies = movieService.getPopularMovies(apiKey)
            movieLiveData.postValue(popularMovies.results)
        } catch (exception: Exception) {
            errorLiveData.postValue("An error occurred:${exception.message}")
        }
    }
}