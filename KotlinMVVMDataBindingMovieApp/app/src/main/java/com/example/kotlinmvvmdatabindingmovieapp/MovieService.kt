package com.example.kotlinmvvmdatabindingmovieapp

import com.example.kotlinmvvmdatabindingmovieapp.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): MoviesResponse
}