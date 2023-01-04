package com.example.kotlinmvvmdatabindingmovieapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinmvvmdatabindingmovieapp.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovies(movies: List<Movie>)
    @Query("SELECT * FROM movies")
    fun getMovies(): List<Movie>
}