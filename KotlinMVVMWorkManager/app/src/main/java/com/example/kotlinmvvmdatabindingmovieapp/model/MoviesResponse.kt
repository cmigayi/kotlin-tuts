package com.example.kotlinmvvmdatabindingmovieapp.model

data class MoviesResponse (
    val page: Int,
    val results: List<Movie>
)