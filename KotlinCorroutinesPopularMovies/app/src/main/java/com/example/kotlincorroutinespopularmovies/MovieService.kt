package com.example.kotlincorroutinespopularmovies

import com.example.kotlincorroutinespopularmovies.model.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): PopularMoviesResponse
}