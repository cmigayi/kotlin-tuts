package com.example.kotlinmvvmdatabindingmovieapp

import android.app.Application
import com.example.kotlinmvvmdatabindingmovieapp.database.MovieDatabase
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieApplication: Application() {
    lateinit var movieRepository: MovieRepository

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val movieService = retrofit.create(MovieService::class.java)
//        movieRepository = MovieRepository(movieService)

        val movieDatabase = MovieDatabase.getInstance(applicationContext)
        movieRepository = MovieRepository(movieService, movieDatabase)
    }
}