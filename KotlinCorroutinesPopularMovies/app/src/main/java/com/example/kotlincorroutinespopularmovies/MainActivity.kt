package com.example.kotlincorroutinespopularmovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincorroutinespopularmovies.model.Movie
import java.util.*

class MainActivity : AppCompatActivity() {
    private val movieAdapter by lazy {
        MovieAdapter(object : MovieAdapter.MovieClickListener {
            override fun onMovieClick(movie: Movie) {
                openMovieDetails(movie)
            }
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.movie_list)
        recyclerView.adapter = movieAdapter

        val movieRepository = (application as MovieApplication).movieRepository
        val movieViewModel =
            ViewModelProvider(this, object: ViewModelProvider.Factory {
                override fun <T : ViewModel>
                        create(modelClass: Class<T>): T {
                    return MovieViewModel(movieRepository) as T
                }
            }).get(MovieViewModel::class.java)
        movieViewModel.popularMovies.observe(this, { popularMovies ->
            var year = Calendar.getInstance().get(Calendar.YEAR)-1

            movieAdapter.addMovies(popularMovies.filter {
                    it.release_date.startsWith(
                            year.toString()
                    )
                }
                .sortedBy { it.title }
            )
        })
        movieViewModel.getError().observe(this, { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
    }

    private fun openMovieDetails(movie: Movie) {
        val intent =
            Intent(this, DetailsActivity::class.java).apply {
                putExtra(DetailsActivity.EXTRA_MOVIE, movie)
            }
        startActivity(intent)
    }
}