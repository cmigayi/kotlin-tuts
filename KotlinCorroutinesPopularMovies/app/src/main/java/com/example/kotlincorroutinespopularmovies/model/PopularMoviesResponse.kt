package com.example.kotlincorroutinespopularmovies.model

data class PopularMoviesResponse (
    val page: Int,
    val results: List<Movie>
)