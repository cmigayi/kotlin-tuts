package com.example.kotlinmvvmdatabindingmovieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmdatabindingmovieapp.database.MovieDao
import com.example.kotlinmvvmdatabindingmovieapp.database.MovieDatabase
import com.example.kotlinmvvmdatabindingmovieapp.model.Movie

class MovieRepository(private var movieService: MovieService, private val movieDatabase: MovieDatabase) {
    private val apiKey = "5fc17697797b23a50431f88e3634466f"
    private val movieLiveData = MutableLiveData<List<Movie>>()
    private val errorLiveData = MutableLiveData<String>()
    val movies: LiveData<List<Movie>> get() = movieLiveData
    val error: LiveData<String> get() = errorLiveData

    suspend fun fetchMovies() {
        val movieDao: MovieDao = movieDatabase.movieDao()
        var moviesFetched = movieDao.getMovies()
        if (moviesFetched.isEmpty()) {
            try {
                val popularMovies = movieService.getMovies(apiKey)
                moviesFetched = popularMovies.results
                movieDao.addMovies(moviesFetched)
            } catch (exception: Exception) {
                errorLiveData.postValue("An error occurred: ${exception.message}")
            }
        }
        movieLiveData.postValue(moviesFetched)
    }
}