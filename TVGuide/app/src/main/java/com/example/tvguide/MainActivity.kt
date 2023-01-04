package com.example.tvguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tvguide.model.TVShow

class MainActivity : AppCompatActivity() {
    private val tvShowAdapter by lazy {
        TVShowAdapter(object : TVShowAdapter.TVShowClickListener {
            override fun onTVShowClick(tvShow: TVShow) {
                openTVShowDetails(tvShow)
            }
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.tv_show_list)
        recyclerView.adapter = tvShowAdapter

        val tvShowRepository = (application as TVApplication).tvShowRepository
        val tvShowViewModel =
            ViewModelProvider(this, object: ViewModelProvider.Factory {
                override fun <T : ViewModel>
                        create(modelClass: Class<T>): T {
                    return TVShowViewModel(tvShowRepository) as T
                }
            }).get(TVShowViewModel::class.java)
        tvShowViewModel.tvShows.observe(this, { tvShows ->
//            var year = Calendar.getInstance().get(Calendar.YEAR)-1
//
//            movieAdapter.addMovies(popularMovies.filter {
//                    it.release_date.startsWith(
//                            year.toString()
//                    )
//                }
//                .sortedBy { it.title }
//            )
            tvShowAdapter.addTVShows(tvShows)
        })
        tvShowViewModel.getError().observe(this, { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
    }

    private fun openTVShowDetails(tvShow: TVShow) {
        val intent =
            Intent(this, DetailsActivity::class.java).apply {
                putExtra(DetailsActivity.EXTRA_TV_SHOW, tvShow)
            }
        startActivity(intent)
    }
}