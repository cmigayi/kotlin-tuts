package com.example.kotlinmvvmdatabindingmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.kotlinmvvmdatabindingmovieapp.databinding.ActivityDetailsBinding
import com.example.kotlinmvvmdatabindingmovieapp.databinding.ActivityMainBinding
import com.example.kotlinmvvmdatabindingmovieapp.model.Movie

class DetailsActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "movie"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w185/"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_details)
        val binding: ActivityDetailsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_details)

//        val titleText: TextView = findViewById(R.id.title_text)
//        val releaseText: TextView = findViewById(R.id.release_text)
//        val overviewText: TextView = findViewById(R.id.overview_text)
//        val poster: ImageView = findViewById(R.id.poster_iv)
        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        movie?.run {
            binding.titleText.text = title
            binding.releaseText.text = release_date.take(4)
            binding.overviewText.text = "Overview: $overview"
            Glide.with(this@DetailsActivity)
                .load("$IMAGE_URL$poster_path")
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(binding.posterIv)
        }
    }
}