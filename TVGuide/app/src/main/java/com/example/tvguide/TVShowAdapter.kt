package com.example.tvguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvguide.model.TVShow

class TVShowAdapter(private val clickListener: TVShowClickListener):
    RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {

    private val tvShows = mutableListOf<TVShow>()
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): TVShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_tv_show_item, parent, false)
        return TVShowViewHolder(view)
    }

    class TVShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageUrl = "https://image.tmdb.org/t/p/w185/"
        private val titleText: TextView by lazy {
            itemView.findViewById(R.id.show_name_tv)
        }
        private val poster: ImageView by lazy {
            itemView.findViewById(R.id.poster_iv)
        }
        fun bind(tvShow: TVShow) {
            titleText.text = tvShow.name
            Glide.with(itemView.context)
                .load("$imageUrl${tvShow.poster_path}")
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(poster)
        }
    }

    override fun getItemCount() = tvShows.size

    override fun onBindViewHolder(holder: TVShowViewHolder,
                                  position: Int) {
        val tvShow = tvShows[position]
        holder.bind(tvShow)
        holder.itemView.setOnClickListener {
            clickListener.onTVShowClick(tvShow) }
    }
    fun addTVShows(movieList: List<TVShow>) {
        tvShows.addAll(movieList)
        notifyItemRangeInserted(0, movieList.size)
    }

    interface TVShowClickListener {
        fun onTVShowClick(tvShow: TVShow)
    }
}