package com.example.tvguide

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvguide.model.TVShow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowViewModel(private var tvShowRepository: TVShowRepository): ViewModel() {
    init {
        fetchTVShows()
    }
    val tvShows: LiveData<List<TVShow>> get() = tvShowRepository.tvShows
    fun getError(): LiveData<String> = tvShowRepository.error

    private fun fetchTVShows() {
        viewModelScope.launch(Dispatchers.IO)  {
            tvShowRepository.fetchTVShows()
        }
    }
}